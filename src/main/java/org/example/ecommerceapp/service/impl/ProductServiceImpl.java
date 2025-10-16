package org.example.ecommerceapp.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.ecommerceapp.models.Product;
import org.example.ecommerceapp.repository.ProductRepository;
import org.example.ecommerceapp.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        if(!productRepository.existsById(id)){
            throw new EntityNotFoundException("Product not found with id: "+id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore) {
        return productRepository.findAllByPriceBetween(price,priceBefore);
    }
//    TODO: feature work with stocks
//    @Override
//    public List<Product> findByStockGreaterThan(Integer stockIsGreaterThan) {
//        return productRepository.findByStock;
//    }

    @Override
    public List<Product> findAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Product> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }
}
