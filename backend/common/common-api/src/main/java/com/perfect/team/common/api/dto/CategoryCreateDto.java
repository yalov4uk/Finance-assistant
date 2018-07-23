package com.perfect.team.common.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoryCreateDto {

  @NotNull
  private String name;

  private String icon;

  @Pattern(regexp = "(income)|(outcome)")
  @NotNull
  private String type;

  @NotNull
  private Long userId;

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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
