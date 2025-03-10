package com.sanjay.car.rental;

import com.sanjay.car.rental.entity.Car;
import com.sanjay.car.rental.entity.CarStatus;
import com.sanjay.car.rental.entity.SubType;
import com.sanjay.car.rental.payment.CreditCardPaymentProcessor;
import com.sanjay.car.rental.payment.PaymentProcessor;
import com.sanjay.car.rental.entity.User;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class CarRentalApp {
    private static CarRentalApp instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

    private CarRentalApp() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new CreditCardPaymentProcessor();
    }

    public static synchronized CarRentalApp getInstance() {
        if(instance == null) {
            instance = new CarRentalApp();
        }
        return instance;
    }
    public void addCar(Car car) {
        this.cars.put(car.getLicensePlate(), car);
    }
    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        return cars.values().stream()
                .filter(car -> car.getMake().equalsIgnoreCase(make))
                .filter(car -> car.getModel().equalsIgnoreCase(model) && car.getCarStatus().equals(CarStatus.AVAILABLE))
                .filter(car -> isCarAvailable(car , startDate, endDate)).collect(Collectors.toList());
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
       for(Reservation reservation : reservations.values()) {
           if(reservation.getCar().equals(car)) {
               if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                   return false;
               }
           }
       }
       return true;
    }

    public synchronized Reservation makeReservation(User user, Car car, SubType subType, LocalDate startDate, LocalDate endDate, double promoDiscount) {
        if(isCarAvailable(car, startDate, endDate)) {
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, user, car, subType, startDate, endDate, promoDiscount);
            double totalPrice = calculateTotalPrice(car, subType, promoDiscount, startDate, endDate);
            reservation.setTotalPrice(totalPrice);
            reservations.put(reservationId, reservation);
            car.setCarStatus(CarStatus.RESERVED);
            return reservation;
        }
        return null;
    }

    private double calculateTotalPrice(Car car, SubType subType, double promoDiscount , LocalDate startDate , LocalDate endDate) {

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        int year = startDate.getYear();
        double totalPrice = 0.0;

        switch (subType) {
            case DAY:
                totalPrice = (daysBetween * car.getDailyPrice()) - promoDiscount;
                break;
            case WEEK:
                long week = daysBetween / 7;
                totalPrice = (week * 7 * car.getDailyPrice()) - promoDiscount;
                break;
            case MONTH:
                int days = 0;
                while(startDate.getMonthValue() <= endDate.getMonthValue()) {
                   Month month =  startDate.getMonth();
                   YearMonth yearMonth = YearMonth.of(year, month);
                   days += yearMonth.lengthOfMonth();
                   startDate = startDate.plusMonths(1);
                }
                totalPrice = (days * car.getDailyPrice()) - promoDiscount;
                break;
            default:
                boolean isLeapYear = Year.isLeap(year);
                int daysInYear = isLeapYear ? 366 : 365;
                totalPrice = (daysInYear * car.getDailyPrice()) - promoDiscount;
                break;
        }
        return totalPrice;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if(Objects.nonNull(reservation)) {
            reservation.getCar().setCarStatus(CarStatus.AVAILABLE);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservationId() {
        return "RES " + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


}
