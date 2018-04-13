package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.CategoryUpdateDto;
import com.perfect.team.api.validation.constraint.AtLeastOneNotNull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CategoryUpdateRequest {

  @NotNull
  @AtLeastOneNotNull(fieldNames = {"name", "icon", "type"})
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
