package org.example.ecommerceapp.service.impl;

import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.repository.CardRepository;
import org.example.ecommerceapp.repository.UserRepository;
import org.example.ecommerceapp.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardServiceImpl(CardRepository cardRepository,UserRepository userRepository){
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Card card, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        card.setUser(user);
        cardRepository.save(card);
    }
    @Override
    public List<Card> getAllCardsByUserId(Long id) {
        return cardRepository.findAllByUserId(id);
    }
}
