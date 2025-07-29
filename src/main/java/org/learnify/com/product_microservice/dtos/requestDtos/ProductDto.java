package org.learnify.com.product_microservice.dtos.requestDtos;

//import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is require") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is require") String name) {
        this.name = name;
    }

    public @Size(max = 255, message = "Description must be under 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 255, message = "Description must be under 255 characters") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") @DecimalMax(value = "10000", message = "Price must not be exceed 10,000") BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") @DecimalMax(value = "10000", message = "Price must not be exceed 10,000") BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public @NotBlank(message = "ImageUrl is required") String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank(message = "ImageUrl is required") String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Min(value = 0, message = "Stocks can't be negative")
    @Max(value = 10000, message = "Stocks can't be exceed 10000")
    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(@Min(value = 0, message = "Stocks can't be negative") @Max(value = 10000, message = "Stocks can't be exceed 10000") int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must not exceed 5") Integer getRatings() {
        return ratings;
    }

    public void setRatings(@Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must not exceed 5") Integer ratings) {
        this.ratings = ratings;
    }

    public @NotNull(message = "Category is required") String getCategory() {
        return category;
    }

    public void setCategory(@NotNull(message = "Category is required") String category) {
        this.category = category;
    }
}
