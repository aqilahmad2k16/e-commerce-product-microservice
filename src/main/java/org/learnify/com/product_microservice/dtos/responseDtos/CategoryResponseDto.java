package org.learnify.com.product_microservice.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
