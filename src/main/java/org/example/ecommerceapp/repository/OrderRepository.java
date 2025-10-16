package org.example.ecommerceapp.repository;


import org.example.ecommerceapp.models.Order;
import org.example.ecommerceapp.models.enums.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.id=:id")
    List<Order> findOrderByUserId(Long id);

    @EntityGraph(attributePaths = {"items", "items.product"})
    @Query("select o from Order o")
    List<Order> findAll();

    List<Order> findOrderByStatus(OrderStatus status);
}
