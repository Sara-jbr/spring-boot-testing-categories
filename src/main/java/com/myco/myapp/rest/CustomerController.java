package com.myco.myapp.rest;

import com.myco.myapp.service.CustomerService;
import com.myco.myapp.doamin.Customer;
import com.myco.myapp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        logger.info("--------CustomerController()---------");
    }

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}