package org.example.ecommerceapp.payment.Decorators;


import org.example.ecommerceapp.payment.BaseComponent.Payment;

public class DiscountDecorator extends PaymentDecorator{
    private double discount;

    public DiscountDecorator(Payment payment, double discount) {
        super(payment);
        this.discount = discount;
    }

    @Override
    public double process(double amount) {
        double discounted = amount * (1 - discount);
        return payment.process(discounted);
    }
}
