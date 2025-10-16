package org.example.ecommerceapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Double totalAmount = 0.0;

    public Cart() {}

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Cart(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
        this.totalAmount = order.getTotalAmount();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}