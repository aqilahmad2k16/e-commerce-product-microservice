package org.learnify.com.product_microservice.services;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductCategoryDto;
import org.learnify.com.product_microservice.dtos.requestDtos.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ResponseEntity<ProductDto> createProduct(ProductDto productRequestDto);

    List<ProductDto> getProductsByCategoryId(Long categoryId);
    List<ProductDto> getProductsByName(String productName);
    ProductDto getProductById(Long productId);
    List<ProductCategoryDto> getProductCategories();
}
