package org.learnify.com.product_microservice.mapper;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductCategoryDto;
import org.learnify.com.product_microservice.models.Category;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {
    private static ModelMapper modelMapper = new ModelMapper();

   public static ProductCategoryDto toDto(Category category) {
       return modelMapper.map(category, ProductCategoryDto.class);
   }

   public static Category toEntity(ProductCategoryDto dto) {
       return modelMapper.map(dto, Category.class);
   }
}
