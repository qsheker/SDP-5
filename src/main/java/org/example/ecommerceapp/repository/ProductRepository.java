package org.example.ecommerceapp.repository;

import org.example.ecommerceapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p ORDER BY p.price DESC ")
    List<Product> findAllByOrderByPriceDesc();

    @Query("select p from Product p ORDER BY p.price ASC ")
    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByPriceBetween(BigDecimal priceAfter, BigDecimal priceBefore);
}
