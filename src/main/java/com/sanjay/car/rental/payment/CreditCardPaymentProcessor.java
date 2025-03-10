package com.sanjay.car.rental.payment;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of amount "+ amount + " is Successful using Credit Card");
        return true;
    }
}
