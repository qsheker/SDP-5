package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void save(Order order);
    List<Order> getOrdersByUserId(Long id);
}
