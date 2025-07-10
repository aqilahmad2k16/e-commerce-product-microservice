package org.learnify.com.product_microservice.services.implservices;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductRequestDto;
import org.learnify.com.product_microservice.dtos.responseDtos.ProductResponseDto;
import org.learnify.com.product_microservice.exception.ProductFetchEexception;
import org.learnify.com.product_microservice.models.Category;
import org.learnify.com.product_microservice.models.Product;
import org.learnify.com.product_microservice.repositories.ProductRepository;
import org.learnify.com.product_microservice.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImplService implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        try{
           List<Product> products = productRepository.findAll();
           List<ProductResponseDto> productResponseDtos = products.stream()
                   .map(product -> {
                       ProductResponseDto productResponseDto = new ProductResponseDto();
                       BeanUtils.copyProperties(product, productResponseDto);
                       productResponseDto.setCategory(String.valueOf(product.getCategory()));
                       return productResponseDto;
                   }).toList();
            return productResponseDtos;
        } catch (Exception e) {
            throw new ProductFetchEexception("Failed to fetch products", e);
        }
    }

    @Override
    public ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto) {
        return null;
    }
}
