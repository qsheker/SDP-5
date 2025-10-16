package org.example.ecommerceapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerceapp.models.enums.Role;


import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "orders")
@Table(name = "users")
@EqualsAndHashCode(exclude = "orders")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,  unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order){
        orders.add(order);
        order.setUser(this);
    }
}
