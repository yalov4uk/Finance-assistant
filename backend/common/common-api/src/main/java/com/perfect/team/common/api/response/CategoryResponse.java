package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.CategoryReadDto;

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
