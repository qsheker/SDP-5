package org.example.ecommerceapp.payment.Decorators;

import org.example.ecommerceapp.payment.BaseComponent.Payment;

public class CashbackDecorator extends PaymentDecorator{

    public CashbackDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double process(double amount) {
        double result = payment.process(amount);
        System.out.println("Cashback: " +(amount * 0.05));
        return result;
    }

}
