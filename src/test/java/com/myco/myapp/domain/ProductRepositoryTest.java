package com.myco.myapp.domain;


import com.myco.myapp.doamin.Product;
import com.myco.myapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldGetAllActiveProducts() {
        //Arrange
        entityManager.persist(new Product(null, "book", "this book about animals", BigDecimal.TEN, false));
        entityManager.persist(new Product(null, "pencil", "this pen has high quality for paining", BigDecimal.TEN, true));

        //Act
        List<Product> products = productRepository.findAllActiveProducts();

        //Assert
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("book");
    }
}


