package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    List<Card> getAllCardsByUserId(Long id);
    void save(Card card, Long id);
}
