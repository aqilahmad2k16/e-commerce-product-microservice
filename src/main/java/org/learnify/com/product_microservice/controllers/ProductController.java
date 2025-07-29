package org.learnify.com.product_microservice.controllers;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductCategoryDto;
import org.learnify.com.product_microservice.dtos.requestDtos.ProductDto;
import org.learnify.com.product_microservice.dtos.responseDtos.ApiResponse;
import org.learnify.com.product_microservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
    Fetch all products
     */
    @GetMapping(value = "/products",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> storeProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    /*
    fetch products by productId
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable("productId") Long productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto productById = productService.getProductById(productId);
        if(productById != null) {
            response.setData(productById);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Fetched product successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Product not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /*
    fetch products by category
     */
    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProductByCategoryId(@PathVariable("categoryId") Long categoryId) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> productsByCategoryId = productService.getProductsByCategoryId(categoryId);
        if(productsByCategoryId != null) {
            response.setData(productsByCategoryId);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Fetched products successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Products not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /*
    search product by prduct name
     */
    @GetMapping("/products/search")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProductByName(@RequestParam("name") String productName) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> productsByName = productService.getProductsByName(productName);
        if(productsByName != null) {
            response.setData(productsByName);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Fetched products successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Product not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /*
    Fetch all categories
     */
    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> getCategories() {
        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();
        List<ProductCategoryDto> productCategories = productService.getProductCategories();
        if(productCategories != null) {
            response.setData(productCategories);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Fetched categories successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Categories not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
