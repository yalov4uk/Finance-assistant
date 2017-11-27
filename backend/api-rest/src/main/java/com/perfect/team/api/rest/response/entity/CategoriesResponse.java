package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public class CategoriesResponse {

    @JsonProperty(value = "categories")
    private List<CategoryDto> categoryDtos;

    public List<CategoryDto> getCategoryDtos() {
        return categoryDtos;
    }

    public void setCategoryDtos(List<CategoryDto> categoryDtos) {
        this.categoryDtos = categoryDtos;
    }
}
