package org.learnify.com.product_microservice.services.implservices;

import org.learnify.com.product_microservice.dtos.responseDtos.CategoryResponseDto;
import org.learnify.com.product_microservice.repositories.CategoryRepository;
import org.learnify.com.product_microservice.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryImplService implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<CategoryResponseDto> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(category -> {
            CategoryResponseDto responseDto = new CategoryResponseDto();
            BeanUtils.copyProperties(category, responseDto);
            return responseDto;
        });
    }
}
