package org.example.ecommerceapp.payment.Decorators;

import org.example.ecommerceapp.models.enums.PaymentMethod;
import org.example.ecommerceapp.payment.BaseComponent.Payment;

public abstract class PaymentDecorator implements Payment{
    protected Payment payment;

    public PaymentDecorator(Payment payment) {
        this.payment = payment;
    }

    @Override
    public PaymentMethod getMethod() {
        return payment.getMethod();
    }

}
