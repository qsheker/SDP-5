package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.Order;
import org.example.ecommerceapp.models.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface OrderService {
    void save(Order order);
    List<Order> getOrdersByUserId(Long id);
    BigDecimal getTotalForUserId(Long id);
    void update(Long id, Order order);
    void updateOrderStatus(List<Order> orders, OrderStatus orderStatus);
    Order getOrderById(Long id);
}
