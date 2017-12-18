package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryOutDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class CategoryResponse {

    @JsonProperty(value = "category")
    private CategoryOutDto categoryDto;

    public CategoryOutDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryOutDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
