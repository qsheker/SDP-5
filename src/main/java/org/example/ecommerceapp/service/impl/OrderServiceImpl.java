package org.example.ecommerceapp.service.impl;

import org.example.ecommerceapp.models.Order;
import org.example.ecommerceapp.repository.OrderRepository;
import org.example.ecommerceapp.service.OrderService;
import org.springframework.stereotype.Service;

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
}
