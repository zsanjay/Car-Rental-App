package com.sanjay.car.rental.entity;

public enum SubType {
    DAY("Daily"), WEEK("Weekly"), MONTH("Monthly"), YEAR("Yearly");
    private final String name;
    SubType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
