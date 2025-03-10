package com.sanjay.car.rental.entity;

import java.util.Date;
public class DrivingLicense {
    private final String name;
    private String nationality;
    private final String licenseNumber;
    private Date dob;
    private Date issueDate;
    private Date expiryDate;
    private String placeOfIssue;

    public DrivingLicense(String name , String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
}
