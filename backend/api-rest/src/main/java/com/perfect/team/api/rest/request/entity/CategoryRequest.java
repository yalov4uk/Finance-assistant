package com.perfect.team.api.rest.request.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryDto;

public class CategoryRequest {

    @JsonProperty(value = "category")
    private CategoryDto categoryDto;

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
