package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.CategoryOutDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public class CategoriesResponse {

    @JsonProperty(value = "categories")
    private List<CategoryOutDto> categoryDtos;

    public List<CategoryOutDto> getCategoryDtos() {
        return categoryDtos;
    }

    public void setCategoryDtos(List<CategoryOutDto> categoryDtos) {
        this.categoryDtos = categoryDtos;
    }
}
