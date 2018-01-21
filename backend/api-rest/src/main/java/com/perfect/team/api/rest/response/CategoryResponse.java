package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.CategoryReadDto;

public class CategoryResponse {

    @JsonProperty(value = "category")
    private CategoryReadDto categoryReadDto;

    public CategoryReadDto getCategoryReadDto() {
        return categoryReadDto;
    }

    public void setCategoryReadDto(CategoryReadDto categoryReadDto) {
        this.categoryReadDto = categoryReadDto;
    }
}
