package com.sanjay.car.rental;

import com.sanjay.car.rental.entity.*;
import com.sanjay.car_rental.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CarRentalAppDemo {
    public static void main(String[] args) {
        CarRentalApp carRentalApp = CarRentalApp.getInstance();

        // Add cars to the rental system
        carRentalApp.addCar(new Car(1,"Toyota", "Camry", 2022, "ABC123", 50.0, CarType.SEDAN));
        carRentalApp.addCar(new Car(2,"Honda", "Civic", 2021, "XYZ789", 45.0, CarType.SEDAN));
        carRentalApp.addCar(new Car(3,"Ford", "Mustang", 2023, "DEF456", 80.0, CarType.SPORTS));

        // Create customers
        DrivingLicense drivingLicense = new DrivingLicense("Sanjay Mehta" , "DL1234");
        IdentityCard identityCard = new IdentityCard("DUB4325243" , "53454365342" , "Sanjay Mehta");
        User user = new User("Sanjay Mehta", "+971 506344397", "sanjay@gmail.com", drivingLicense, identityCard);

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars = carRentalApp.searchCars("Toyota", "Camry", startDate, endDate);
        if(!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            Reservation reservation = carRentalApp.makeReservation(user, selectedCar, SubType.DAY, startDate, endDate, 5.0);
            if(Objects.nonNull(reservation)) {
                boolean paymentSuccess = carRentalApp.processPayment(reservation);
                if(paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                } else {
                    System.out.println("Payment failed. Reservation cancelled.");
                    carRentalApp.cancelReservation(reservation.getReservationId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}
