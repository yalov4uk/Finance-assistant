package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.CategoryReadDto;

import java.util.List;

public class CategoriesResponse {

    @JsonProperty(value = "categories")
    private List<CategoryReadDto> categoryReadDtos;

    public List<CategoryReadDto> getCategoryReadDtos() {
        return categoryReadDtos;
    }

    public void setCategoryReadDtos(List<CategoryReadDto> categoryReadDtos) {
        this.categoryReadDtos = categoryReadDtos;
    }
}
