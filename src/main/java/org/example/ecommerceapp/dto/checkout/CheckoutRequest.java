package org.example.ecommerceapp.dto.checkout;

import lombok.Data;
import org.example.ecommerceapp.models.enums.PaymentMethod;

@Data
public class CheckoutRequest {
    private Long userId;
    private Long userCardId;
    private PaymentMethod paymentMethod;
    private double amount;
    private double discount;
    private boolean cashback;
    private boolean fraudCheck;
}
