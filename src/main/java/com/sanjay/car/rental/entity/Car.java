package com.sanjay.car.rental.entity;

import java.util.List;

public class Car {
    private final int carId;
    private double dailyPrice;
    private String make;
    private String model;
    private final int year;
    private String fuel;
    private String gear;
    private String engine;
    private String transmission;
    private int maxPower;
    private int torque;
    private int seats;
    private String color;
    private String licensePlate;
    private List<String> imageURLs;
    private List<CarFeature> carFeatures;
    private CarType carType;
    private CarStatus carStatus;
    private Company company;

    public Car(int carId, String make, String model, int year, String licensePlate, double dailyPrice, CarType carType) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.dailyPrice = dailyPrice;
        this.carType = carType;
        this.carStatus = CarStatus.AVAILABLE;
    }

    public int getCarId() {
        return carId;
    }

    public int getYear() {
        return year;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(List<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public List<CarFeature> getCarFeatures() {
        return carFeatures;
    }

    public void setCarFeatures(List<CarFeature> carFeatures) {
        this.carFeatures = carFeatures;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
