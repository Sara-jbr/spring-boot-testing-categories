package com.myco.myapp.service;

import com.myco.myapp.repository.CustomerRepository;
import com.myco.myapp.doamin.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        logger.info("--------CustomerService()---------");
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}