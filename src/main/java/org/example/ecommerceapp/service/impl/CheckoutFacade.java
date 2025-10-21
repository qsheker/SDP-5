package org.example.ecommerceapp.service.impl;

import org.example.ecommerceapp.web.dto.checkout.CheckoutRequest;
import org.example.ecommerceapp.models.enums.PaymentMethod;
import org.example.ecommerceapp.payment.BaseComponent.Payment;
import org.example.ecommerceapp.payment.ConcreteClasses.CreditCardPayment;
import org.example.ecommerceapp.payment.ConcreteClasses.PayPalPayment;
import org.example.ecommerceapp.payment.Decorators.CashbackDecorator;
import org.example.ecommerceapp.payment.Decorators.DiscountDecorator;
import org.example.ecommerceapp.payment.Decorators.FraudDetectionDecorator;
import org.springframework.stereotype.Service;

@Service
public class CheckoutFacade {

    public double processCheckout(CheckoutRequest request) {
        Payment payment = createPayment(request.getPaymentMethod());

        if (request.getDiscount() > 0) {
            payment = new DiscountDecorator(payment, request.getDiscount());
        }
        if (request.isCashback()) {
            payment = new CashbackDecorator(payment);
        }
        if (request.isFraudCheck()) {
            payment = new FraudDetectionDecorator(payment);
        }

        return payment.process(request.getAmount());
    }

    private Payment createPayment(PaymentMethod method) {
        return switch (method) {
            case CREDIT_CARD -> new CreditCardPayment();
            case PAYPAL -> new PayPalPayment();
            default -> throw new IllegalArgumentException("Unknown payment method");
        };
    }
}
