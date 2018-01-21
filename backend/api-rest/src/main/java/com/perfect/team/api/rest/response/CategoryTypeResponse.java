package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.CategoryTypeReadDto;

public class CategoryTypeResponse {

    @JsonProperty(value = "categoryType")
    private CategoryTypeReadDto categoryTypeReadDto;

    public CategoryTypeReadDto getCategoryTypeReadDto() {
        return categoryTypeReadDto;
    }

    public void setCategoryTypeReadDto(CategoryTypeReadDto categoryTypeReadDto) {
        this.categoryTypeReadDto = categoryTypeReadDto;
    }
}
