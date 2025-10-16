package org.example.ecommerceapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceapp.models.Order;
import org.example.ecommerceapp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
