package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.CategoryCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CategoryCreateRq {

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
