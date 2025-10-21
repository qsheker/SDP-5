package org.example.ecommerceapp.controller;


import org.example.ecommerceapp.web.dto.checkout.CheckoutRequest;
import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.models.enums.OrderStatus;
import org.example.ecommerceapp.service.CardService;
import org.example.ecommerceapp.service.OrderService;
import org.example.ecommerceapp.service.impl.CheckoutFacade;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/checkout")
public class CheckoutController {
    private final CheckoutFacade checkoutFacade;
    private final OrderService orderService;
    private final CardService cardService;

    public CheckoutController(CheckoutFacade checkoutFacade, OrderService orderService, CardService cardService) {
        this.checkoutFacade = checkoutFacade;
        this.orderService = orderService;
        this.cardService = cardService;
    }

    @PostMapping
    public String checkout(@RequestBody CheckoutRequest checkoutRequest){
        var userId = checkoutRequest.getUserId();
        BigDecimal amount = orderService.getTotalForUserId(userId);
        checkoutRequest.setAmount(amount.doubleValue());

        double finalAmountDouble = checkoutFacade.processCheckout(checkoutRequest);
        BigDecimal finalAmount = BigDecimal.valueOf(finalAmountDouble);

        var cards = cardService.getAllCardsByUserId(userId);

        Card card = cardService.checkForValid(cards,finalAmount);
        if (card.getAmount().compareTo(finalAmount) < 0) {
            throw new RuntimeException("Insufficient funds on card ID: " + card.getId());
        }
        var orders = orderService.getOrdersByUserId(userId);
        orderService.updateOrderStatus(orders, OrderStatus.PENDING);
        return "Checkout successful!";
    }

    @PostMapping("/pay/{orderId}")
    public String payOrder(@PathVariable Long orderId) {
        var order = orderService.getOrderById(orderId);
        var userId = order.getUser().getId();
        var finalAmount = order.getTotalAmount();

        Card card = cardService.checkForValid(cardService.getAllCardsByUserId(userId), finalAmount);

        if (card.getAmount().compareTo(finalAmount) < 0) {
            return " " + orderId;
        }

        card.setAmount(card.getAmount().subtract(finalAmount));
        cardService.update(card);

        order.setStatus(OrderStatus.PAID);
        orderService.update(order.getId(),order);

        return "Payment for order with id: " + orderId + " completed successfully!";
    }

    @PostMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {
        var order = orderService.getOrderById(orderId);

        if (order.getStatus() == OrderStatus.PAID) {
            var userId = order.getUser().getId();
            var refundAmount = order.getTotalAmount();

            Card card = cardService.getAllCardsByUserId(userId).get(0);
            card.setAmount(card.getAmount().add(refundAmount));
            cardService.update(card);
        }

        order.setStatus(OrderStatus.CANCELLED);
        orderService.update(order.getId(), order);

        return "Cancelling for order with id: " + orderId + " completed successfully!";
    }
}
