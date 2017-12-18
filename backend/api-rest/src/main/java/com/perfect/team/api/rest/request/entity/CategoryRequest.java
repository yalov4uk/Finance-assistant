package com.perfect.team.api.rest.request.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryInDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class CategoryRequest {

    @JsonProperty(value = "category")
    private CategoryInDto categoryDto;

    public CategoryInDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryInDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
