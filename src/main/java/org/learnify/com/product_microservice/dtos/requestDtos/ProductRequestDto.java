package org.learnify.com.product_microservice.dtos.requestDtos;

//import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    @NotBlank(message = "Name is require")
    private String name;
    @Size(max = 255, message = "Description must be under 255 characters")
    private String description;
    @NotBlank(message = "Title is required")
    private String title;
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @DecimalMax(value = "10000", message = "Price must not be exceed 10,000")
    private BigDecimal unitPrice;
    private boolean active;
    @NotBlank(message = "ImageUrl is required")
    private String imageUrl;
    @Min(value = 0, message = "Stocks can't be negative")
    @Max(value = 10000, message = "Stocks can't be exceed 10000")
    private int unitsInStock;
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must not exceed 5")
    private Integer ratings;
    @NotNull(message = "Category is required")
    private String category;
}
