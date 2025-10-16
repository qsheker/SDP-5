package org.example.ecommerceapp.repository;

import org.example.ecommerceapp.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
