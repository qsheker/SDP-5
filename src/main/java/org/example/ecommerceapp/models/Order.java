package org.example.ecommerceapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private String orderNumber;
    private Double totalAmount;
    private String paymentType;
    private String status = "PENDING";

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private Cart cart;

    public Order() {}

    public Order(String orderNumber, Double totalAmount, String paymentType, Customer customer) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
        this.customer = customer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}