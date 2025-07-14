package org.learnify.com.product_microservice.services;

import org.learnify.com.product_microservice.dtos.responseDtos.CategoryResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<CategoryResponseDto> getAllCategories(Pageable pageable);
}
