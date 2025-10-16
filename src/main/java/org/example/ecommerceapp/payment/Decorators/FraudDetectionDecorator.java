package org.example.ecommerceapp.payment.Decorators;

import org.example.ecommerceapp.payment.BaseComponent.Payment;

public class FraudDetectionDecorator extends PaymentDecorator{
    public FraudDetectionDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double process(double amount) {
        if (amount > 10000) {
            throw new RuntimeException("Fraud detected: Amount too large");
        }
        return payment.process(amount);
    }
}
