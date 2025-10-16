package org.example.ecommerceapp.payment.ConcreteClasses;

import lombok.Data;
import org.example.ecommerceapp.models.enums.PaymentMethod;
import org.example.ecommerceapp.payment.BaseComponent.Payment;

@Data
public class PayPalPayment implements Payment {
    private String paymentMethod;

    @Override
    public PaymentMethod getMethod() {
        var type = PaymentMethod.PAYPAL;
        this.paymentMethod = type.name();
        return type;
    }

    @Override
    public double process(double amount) {
        return amount;
    }
}
