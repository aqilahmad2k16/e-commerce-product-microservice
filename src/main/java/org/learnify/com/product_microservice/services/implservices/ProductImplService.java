package org.learnify.com.product_microservice.services.implservices;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductCategoryDto;
import org.learnify.com.product_microservice.dtos.requestDtos.ProductDto;
import org.learnify.com.product_microservice.exception.CategoryNotFoundException;
import org.learnify.com.product_microservice.exception.ProductFetchEexception;
import org.learnify.com.product_microservice.exception.ProductNotFoundException;
import org.learnify.com.product_microservice.mapper.ProductCategoryMapper;
import org.learnify.com.product_microservice.mapper.ProductMapper;
import org.learnify.com.product_microservice.models.Category;
import org.learnify.com.product_microservice.models.Product;
import org.learnify.com.product_microservice.repositories.CategoryRepository;
import org.learnify.com.product_microservice.repositories.ProductRepository;
import org.learnify.com.product_microservice.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplService implements ProductService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            List<ProductDto> productDtos = products.stream()
                    .map(product -> {
                        ProductDto productDto = new ProductDto();
                        BeanUtils.copyProperties(product, productDto);
                        return productDto;
                    }).toList();
            return productDtos;
        } catch (Exception e) {
            throw new ProductFetchEexception("Failed to fetch products", e);
        }
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productRequestDto) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        List<Product> productsByCategory = productRepository.findByCategory_CategoryId(categoryId);
        if (productsByCategory.isEmpty()) {
            throw new ProductNotFoundException("No products found for the category: " + categoryId);
        }

        return productsByCategory
                .stream()
                .map(ProductMapper::toDto)
                .toList();

    }

    @Override
    public List<ProductDto> getProductsByName(String productName) {
        List<Product> productEntities = productRepository.findByNameContainingIgnoreCase(productName);
        if (productEntities.isEmpty()) {
            throw new ProductNotFoundException("No products found of this name: " + productName);
        }
        return productEntities
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        return ProductMapper.toDto(product.get());
    }

    @Override
    public List<ProductCategoryDto> getProductCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new CategoryNotFoundException("No categories found");
        }
        return categories
                .stream()
                .map(ProductCategoryMapper::toDto)
                .toList();
    }
}
