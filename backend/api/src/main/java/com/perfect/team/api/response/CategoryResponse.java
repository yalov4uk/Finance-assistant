package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.CategoryReadDto;

public class CategoryResponse {

  @JsonProperty(value = "category")
  private CategoryReadDto categoryDto;

  public CategoryReadDto getCategoryDto() {
    return categoryDto;
  }

  public void setCategoryDto(CategoryReadDto categoryDto) {
    this.categoryDto = categoryDto;
  }
}
