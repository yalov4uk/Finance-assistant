package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.CategoryReadDto;

public class CategoryRs {

  @JsonProperty(value = "category")
  private CategoryReadDto categoryReadDto;

  public CategoryReadDto getCategoryReadDto() {
    return categoryReadDto;
  }

  public void setCategoryReadDto(CategoryReadDto categoryReadDto) {
    this.categoryReadDto = categoryReadDto;
  }
}
