package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import com.perfect.team.legacy.api.dto.CategoryUpdateDto;
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
