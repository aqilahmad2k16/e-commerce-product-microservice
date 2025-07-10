package org.learnify.com.product_microservice.serviceTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learnify.com.product_microservice.dtos.responseDtos.ProductResponseDto;
import org.learnify.com.product_microservice.models.Category;
import org.learnify.com.product_microservice.models.Product;
import org.learnify.com.product_microservice.repositories.ProductRepository;
import org.learnify.com.product_microservice.services.implservices.ProductImplService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductImplService productImplService;

    private static Product product = null;

    @BeforeAll
    public static void setUp() {
        product = new Product();
    }

    @Test
    public void shouldReturnListOfProducts() {
        // Create Category object
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("Electronics");
        category.setDateCreated(LocalDate.now());
        category.setLastUpdated(LocalDate.now());

        // Create Product object using setters
        product.setId(1L);
        product.setName("iPhone 15");
        product.setDescription("Latest iPhone model");
        product.setTitle("Apple iPhone");
        product.setUnitPrice(new BigDecimal("1199.99"));
        product.setActive(true);
        product.setImageUrl("https://example.com/iphone15.jpg");
        product.setUnitsInStock(100);
        product.setRatings("5");
        product.setDateCreated(LocalDate.now());
        product.setLastUpdated(LocalDate.now());
        product.setCategory(category);

        //mock repo
        List<Product> products = List.of(product);
        Mockito.when(productRepository.findAll()).thenReturn(products);

        //call service
        List<ProductResponseDto> result = productImplService.getAllProducts();
    }
}
