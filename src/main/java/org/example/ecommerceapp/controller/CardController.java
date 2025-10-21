package org.example.ecommerceapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.service.CardService;
import org.example.ecommerceapp.web.dto.Card.CardRequestDto;
import org.example.ecommerceapp.web.dto.Card.CardResponseDto;
import org.example.ecommerceapp.web.mappers.card.CardRequestMapper;
import org.example.ecommerceapp.web.mappers.card.CardResponseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/users/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardRequestMapper cardRequestMapper;
    private final CardResponseMapper cardResponseMapper;

    @GetMapping("{userId}")
    public List<Card> getCardsByUser(@PathVariable Long userId) {
        return cardService.getAllCardsByUserId(userId);
    }
    @PostMapping("{userId}")
    public CardResponseDto create(@RequestBody CardRequestDto dto, @PathVariable("userId") Long id){
        Card card = cardRequestMapper.toEntity(dto);
        return cardResponseMapper.toDto(cardService.save(card,id));
    }
    @PostMapping("/cards/addAmount/{id}")
    public ResponseEntity<String> addAmount(
            @PathVariable("id") Long userId,
            @RequestParam String cardNumber,
            @RequestParam BigDecimal amount
    ) {
        cardService.addAmount(amount, userId, cardNumber);
        return ResponseEntity.ok("Amount successfully added to card: " + cardNumber);
    }
}
