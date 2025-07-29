package org.learnify.com.product_microservice.repositories;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductDto;
import org.learnify.com.product_microservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //select*from product where name like "%name%"
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory_CategoryId(Long categoryId);
}
