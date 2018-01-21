package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.CategoryTypeReadDto;

import java.util.List;

public class CategoryTypesResponse {

    @JsonProperty(value = "categoryTypes")
    private List<CategoryTypeReadDto> categoryTypeReadDtos;

    public List<CategoryTypeReadDto> getCategoryTypeReadDtos() {
        return categoryTypeReadDtos;
    }

    public void setCategoryTypeReadDtos(List<CategoryTypeReadDto> categoryTypeReadDtos) {
        this.categoryTypeReadDtos = categoryTypeReadDtos;
    }
}
