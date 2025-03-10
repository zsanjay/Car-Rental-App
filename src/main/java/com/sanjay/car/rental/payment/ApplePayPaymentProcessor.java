package com.sanjay.car.rental.payment;

public class ApplePayPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of amount "+ amount + " is Successful using Apple Pay");
        return true;
    }
}
