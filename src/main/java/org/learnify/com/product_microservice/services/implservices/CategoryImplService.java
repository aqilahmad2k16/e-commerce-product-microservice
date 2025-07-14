package org.learnify.com.product_microservice.services.implservices;

import org.learnify.com.product_microservice.repositories.CategoryRepository;
import org.learnify.com.product_microservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImplService implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

}
