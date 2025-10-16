package org.example.ecommerceapp.repository;

import org.example.ecommerceapp.models.Category;
import org.example.ecommerceapp.models.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"category"})
    @Query("select p from Product p")
    List<Product> findAll();

    List<Product> findProductsByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore);

    List<Product> findByStockGreaterThan(Integer stockIsGreaterThan);

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findByCategoryAndPriceBetweenAndStockGreaterThan(Category category, BigDecimal priceAfter, BigDecimal priceBefore, Integer stockIsGreaterThan);
}
