package com.myco.myapp.domain;

import com.myco.myapp.repository.ProductRepository;
import com.myco.myapp.doamin.Product;
import com.myco.myapp.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceWithMockitoExtensionTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnOnlyActiveProducts() {
        //Arrange
        Product p1 = new Product(1L, "lenovo", "type-1", BigDecimal.TEN, false);
        Product p2 = new Product(2L, "asus", "type-2", BigDecimal.TEN, true);
        BDDMockito.given(productRepository.findAll()).willReturn(List.of(p1, p2));

        //Act
        List<Product> products = productService.getAllProducts();

        //Assert
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getId()).isEqualTo(1L);
    }
}
