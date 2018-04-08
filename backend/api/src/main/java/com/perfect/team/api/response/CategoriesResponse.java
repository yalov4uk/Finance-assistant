package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.CategoryReadDto;
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
