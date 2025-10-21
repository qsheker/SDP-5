package org.example.ecommerceapp.web.dto.Card;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CardResponseDto {
    private Long userId;
    private String cardHolderName;
    private String expirationDate;
}
