package com.sanjay.car.rental.entity;

public class User {
    private final String name;
    private final String contactNumber;
    private final String email;
    private final DrivingLicense drivingLicense;
    private final IdentityCard identityCard;

    public User(String name, String contactNumber, String email, DrivingLicense drivingLicense, IdentityCard identityCard) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.drivingLicense = drivingLicense;
        this.identityCard = identityCard;
    }


}
