package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.CategoryUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CategoryUpdateRq {

  @NotNull
  @Valid
  @JsonProperty(value = "category")
  private CategoryUpdateDto categoryDto;

  public CategoryUpdateDto getCategoryDto() {
    return categoryDto;
  }

  public void setCategoryDto(CategoryUpdateDto categoryDto) {
    this.categoryDto = categoryDto;
  }
}
