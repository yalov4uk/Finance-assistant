package com.perfect.team.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoryCreateDto {

  @NotNull
  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "icon")
  private String icon;

  @Pattern(regexp = "(IN)|(OUT)")
  @NotNull
  @JsonProperty(value = "type")
  private String type;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
