package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.CategoryCreateDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CategoryCreateRequest {

    @NotNull
    @Valid
    @JsonProperty(value = "category")
    private CategoryCreateDto categoryDto;

    public CategoryCreateDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryCreateDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
