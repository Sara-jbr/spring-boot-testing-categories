package com.sara.myapp.repository;



import com.sara.myapp.doamin.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}