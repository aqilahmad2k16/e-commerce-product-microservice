package org.learnify.com.product_microservice.services;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductRequestDto;
import org.learnify.com.product_microservice.dtos.responseDtos.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();

    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto);
}
