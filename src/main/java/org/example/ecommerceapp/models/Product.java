package org.example.ecommerceapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orders"})
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();
}
