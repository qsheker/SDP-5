package org.example.ecommerceapp.payment.BaseComponent;

import org.example.ecommerceapp.models.enums.PaymentMethod;

public interface Payment {
    PaymentMethod getMethod();
    double process(double amount);
}
