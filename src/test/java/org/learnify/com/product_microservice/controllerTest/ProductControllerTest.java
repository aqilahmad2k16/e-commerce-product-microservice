package org.learnify.com.product_microservice.controllerTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learnify.com.product_microservice.controllers.ProductController;
import org.learnify.com.product_microservice.dtos.responseDtos.ProductResponseDto;
import org.learnify.com.product_microservice.exception.ProductFetchEexception;
import org.learnify.com.product_microservice.services.ProductService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.List;

@WebMvcTest(controllers = ProductController.class)
@Import(ProductControllerTest.MockedServiceConfig.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProductService productService; //inject mocked bean;

    private static ProductResponseDto productDto = null;

    @BeforeAll
    public static void setProductResponseDto(){
        productDto = new ProductResponseDto();
    }

    @AfterAll
    public static void clearProductResponseDto(){
        productDto = null;
    }

    @Test
    public void shouldReturnListOfProducts() throws Exception {
        productDto.setId(1L);
        productDto.setName("iPhone 14");
        productDto.setDescription("Latest Apple smartphone with A15 Bionic chip");
        productDto.setTitle("Apple iPhone");
        productDto.setUnitPrice(new BigDecimal("799.99"));
        productDto.setActive(true);
        productDto.setImageUrl("https://example.com/images/iphone14.jpg");
        productDto.setUnitsInStock(50);
        List<ProductResponseDto> mockProducts = List.of(productDto);

        Mockito.when(productService.getAllProducts()).thenReturn(mockProducts);

        mvc.perform(get("/api/products")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.length()").value(1))
                .andExpect((ResultMatcher) jsonPath("$[0].id").value(1))
                .andExpect((ResultMatcher) jsonPath("$[0].name").value("iPhone 14"))
                .andExpect((ResultMatcher) jsonPath("$[0].unitPrice").value(new BigDecimal("799.99")))
                .andExpect((ResultMatcher) jsonPath("$[0].active").value(true))
                .andExpect((ResultMatcher) jsonPath("$[0].imageUrl").value("https://example.com/images/iphone14.jpg"))
                .andExpect((ResultMatcher) jsonPath("$[0].unitsInStock").value(50));

    }

    @Test
    public void shouldReturn500WhenServiceFails() throws Exception {
        Mockito.when(productService.getAllProducts()).thenThrow(new ProductFetchEexception("Failed to fetch products: Service unavailable"));
        mvc.perform(get("/api/products"))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Failed to fetch products: Service unavailable"));
    }

    @TestConfiguration
    static class MockedServiceConfig {
        @Bean
        public ProductService productService() {
            return Mockito.mock(ProductService.class);
        }
    }
}
