package org.learnify.com.product_microservice.controllers;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductRequestDto;
import org.learnify.com.product_microservice.dtos.responseDtos.ProductResponseDto;
import org.learnify.com.product_microservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
    Fetch all products
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDto> storeProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
    
}
