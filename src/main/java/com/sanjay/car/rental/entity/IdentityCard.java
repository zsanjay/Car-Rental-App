package com.sanjay.car.rental.entity;

import java.util.Date;
public class IdentityCard {
    private String idNumber;
    private String cardNumber;
    private String name;
    private String sex;
    private Date dob;
    private String nationality;
    private Date issueDate;
    private Date expiryDate;
    private String placeOfIssue;

    public IdentityCard(String idNumber, String cardNumber, String name) {
        this.idNumber = idNumber;
        this.cardNumber = cardNumber;
        this.name = name;
    }
}
