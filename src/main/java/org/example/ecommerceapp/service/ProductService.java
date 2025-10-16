package org.example.ecommerceapp.service;

import org.example.ecommerceapp.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    void save(Product product);

    void deleteById(Long id);

    List<Product> listAll();

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore);

//    List<Product> findByStockGreaterThan(Integer stockIsGreaterThan);

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByPriceAsc();
}
