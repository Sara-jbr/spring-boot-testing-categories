package com.myco.myapp.rest;

import com.myco.myapp.doamin.Product;
import com.myco.myapp.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
        logger.info("--------ProductController()---------");
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
