package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface CardService {
    List<Card> getAllCardsByUserId(Long id);
    Card save(Card card, Long id);
    Card checkForValid(List<Card> cardList, BigDecimal total);
    void update(Card card);
    void addAmount(BigDecimal amount, Long userId, String cardNumber);
}
