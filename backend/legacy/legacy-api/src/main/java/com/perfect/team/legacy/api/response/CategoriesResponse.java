package com.perfect.team.legacy.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.CategoryReadDto;
import java.util.List;

public class CategoriesResponse {

  @JsonProperty(value = "categories")
  private List<CategoryReadDto> categoryDtos;

  public List<CategoryReadDto> getCategoryDtos() {
    return categoryDtos;
  }

  public void setCategoryDtos(List<CategoryReadDto> categoryDtos) {
    this.categoryDtos = categoryDtos;
  }
}
