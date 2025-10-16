package org.example.ecommerceapp.factory;

import org.example.ecommerceapp.payment.BaseComponent.Payment;

public interface PaymentFactory {
    Payment getPayment();
}
