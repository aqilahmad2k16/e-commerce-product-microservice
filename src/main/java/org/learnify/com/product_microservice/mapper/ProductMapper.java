package org.learnify.com.product_microservice.mapper;

import org.learnify.com.product_microservice.dtos.requestDtos.ProductDto;
import org.learnify.com.product_microservice.models.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ProductDto toDto(Product productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public static Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

}
