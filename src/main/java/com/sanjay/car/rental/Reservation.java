package com.sanjay.car.rental;

import com.sanjay.car.rental.entity.Car;
import com.sanjay.car.rental.entity.SubType;
import com.sanjay.car.rental.entity.User;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private User user;
    private Car car;
    private SubType subType;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private double promotionalDiscount;

    public Reservation(String reservationId, User user, Car car, SubType subType, LocalDate startDate, LocalDate endDate, double promo) {
        this.reservationId = reservationId;
        this.user = user;
        this.car = car;
        this.subType = subType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionalDiscount = promo;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPromotionalDiscount() {
        return promotionalDiscount;
    }

    public void setPromotionalDiscount(double promotionalDiscount) {
        this.promotionalDiscount = promotionalDiscount;
    }
}
