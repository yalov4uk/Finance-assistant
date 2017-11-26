package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class CategoryResponse {

    @JsonProperty(value = "category")
    private CategoryDto categoryDto;

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
