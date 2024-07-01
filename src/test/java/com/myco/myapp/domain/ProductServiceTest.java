package com.myco.myapp.domain;

import com.myco.myapp.doamin.Product;
import com.myco.myapp.repository.ProductRepository;
import com.myco.myapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void shouldReturnOnlyActiveProducts() {
        //Arrange
        Product p1 = new Product(1L, "book", "this book about animals", BigDecimal.TEN, false);
        Product p2 = new Product(2L, "pencil", "this pen has high quality for paining", BigDecimal.TEN, true);
        BDDMockito.given(productRepository.findAll()).willReturn(List.of(p1, p2));

        //Act
        List<Product> products = productService.getAllProducts();

        //Assert
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getId()).isEqualTo(1L);
    }
}
