package org.example.ecommerceapp.service.impl;

import org.example.ecommerceapp.models.Order;
import org.example.ecommerceapp.models.enums.OrderStatus;
import org.example.ecommerceapp.repository.OrderRepository;
import org.example.ecommerceapp.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        return orderRepository.findOrdersByUser_Id(id);
    }

    @Override
    public BigDecimal getTotalForUserId(Long id) {
        BigDecimal total = orderRepository.getTotalSumByUserId(id);
        return total != null ? total : BigDecimal.ZERO;
    }

    @Override
    @Transactional
    public void update(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());

        // existingOrder.setProducts(updatedOrder.getProducts());

        orderRepository.save(existingOrder);
    }

    @Override
    @Transactional
    public void updateOrderStatus(List<Order> orders, OrderStatus orderStatus) {
        for(Order order : orders){
            order.setStatus(orderStatus);
            orderRepository.save(order);
        }
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findOrderById(id);
        if (order == null) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        return order;
    }
}