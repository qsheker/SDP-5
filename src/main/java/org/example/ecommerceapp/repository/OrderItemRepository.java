package org.example.ecommerceapp.repository;


import org.example.ecommerceapp.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long id);
    List<OrderItem> findByProductId(Long id);
}
