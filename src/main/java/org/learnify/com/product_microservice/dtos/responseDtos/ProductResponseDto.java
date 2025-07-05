package org.learnify.com.product_microservice.dtos.responseDtos;

import lombok.Data;
import org.learnify.com.product_microservice.models.Category;

import java.math.BigDecimal;
@Data
public class ProductResponseDto {
    private String name;
    private String description;
    private String title;
    private BigDecimal unitPrice;
    private boolean active;
    private String imageUrl;
    private int unitsInStock;
    private String ratings;
    private Category category;
}
