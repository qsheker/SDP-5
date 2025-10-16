package org.example.ecommerceapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getCardsByUser(@PathVariable Long userId) {
        return cardService.getAllCardsByUserId(userId);
    }
}
