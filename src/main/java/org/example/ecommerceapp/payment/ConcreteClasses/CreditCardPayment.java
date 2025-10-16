package org.example.ecommerceapp.payment.ConcreteClasses;

import lombok.Data;
import org.example.ecommerceapp.factory.PaymentFactory;
import org.example.ecommerceapp.models.enums.PaymentMethod;
import org.example.ecommerceapp.payment.BaseComponent.Payment;

@Data
public class CreditCardPayment implements Payment, PaymentFactory {
    private String paymentMethod;

    @Override
    public PaymentMethod getMethod() {
        var type = PaymentMethod.CREDIT_CARD;
        this.paymentMethod = type.name();
        return type;
    }

    @Override
    public double process(double amount) {
        return amount;
    }

    @Override
    public Payment getPayment() {
        return new CreditCardPayment();
    }
}
