package org.example.ecommerceapp.repository;

import org.example.ecommerceapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
