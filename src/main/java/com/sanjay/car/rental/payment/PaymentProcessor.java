package com.sanjay.car.rental.payment;

public interface PaymentProcessor {
    boolean processPayment(double amount);
}
