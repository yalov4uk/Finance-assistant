package com.perfect.team.api.dto;

import javax.validation.constraints.NotNull;

public class ConfirmationDto {

  @NotNull
  private String code;

  @NotNull
  private Long userId;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
