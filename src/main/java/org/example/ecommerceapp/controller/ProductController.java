package org.example.ecommerceapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceapp.models.Product;
import org.example.ecommerceapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        productService.save(product);
        return "Product created successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "Product deleted successfully";
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.listAll();
    }

    @GetMapping("/filter")
    public List<Product> filterByPriceRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max
    ) {
        return productService.findByPriceBetween(min, max);
    }

    @GetMapping("/desc")
    public List<Product> getProductsByPriceDesc() {
        return productService.findAllByOrderByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Product> getProductsByPriceAsc() {
        return productService.findAllByOrderByPriceAsc();
    }
}
