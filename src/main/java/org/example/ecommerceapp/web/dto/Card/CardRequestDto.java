package org.example.ecommerceapp.web.dto.Card;

import lombok.Data;

@Data
public class CardRequestDto {
    private String cardNumber;

    private String cardHolderName;

    private String expirationDate;

    private String cvv;
}
