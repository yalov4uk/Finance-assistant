package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.CategoryReadDto;
import java.util.List;

public class CategoriesRs {

  @JsonProperty(value = "categories")
  private List<CategoryReadDto> categoryReadDtos;

  public List<CategoryReadDto> getCategoryReadDtos() {
    return categoryReadDtos;
  }

  public void setCategoryReadDtos(List<CategoryReadDto> categoryReadDtos) {
    this.categoryReadDtos = categoryReadDtos;
  }
}
