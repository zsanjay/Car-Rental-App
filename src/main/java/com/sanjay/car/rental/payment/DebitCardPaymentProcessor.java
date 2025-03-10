package com.sanjay.car.rental.payment;

public class DebitCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of amount "+ amount + " is Successful using Debit Card");
        return true;
    }
}
