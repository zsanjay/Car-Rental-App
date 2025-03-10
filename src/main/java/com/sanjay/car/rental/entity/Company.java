package com.sanjay.car.rental.entity;

import java.util.List;
public class Company {
    private String name;

    private String registrationNumber;

    private String cityName;

    // One to Many relationship
    private List<Car> cars;
}
