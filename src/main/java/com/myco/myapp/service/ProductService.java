package com.myco.myapp.service;

import com.myco.myapp.repository.ProductRepository;
import com.myco.myapp.doamin.Product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        logger.info("--------ProductService()---------");
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll()
                    .stream()
                    .filter(p ->!p.isDisabled())
                    .toList();
        } catch (Exception e) {
            logger.error("Failed to retrieve all products", e);
            throw new RuntimeException("Error retrieving products", e);
        }
    }
}

