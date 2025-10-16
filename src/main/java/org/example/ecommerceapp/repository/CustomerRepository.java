package org.example.ecommerceapp.repository;

import org.example.ecommerceapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
