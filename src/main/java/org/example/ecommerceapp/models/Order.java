package org.example.ecommerceapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerceapp.models.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@EqualsAndHashCode(exclude = "user")
public class Order extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime orderDate;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();

    @PrePersist
    public void PrePersist() {
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.NEW;
    }
}