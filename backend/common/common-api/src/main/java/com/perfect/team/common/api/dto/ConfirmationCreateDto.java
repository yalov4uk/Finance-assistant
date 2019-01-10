package com.perfect.team.common.api.dto;

import javax.validation.constraints.NotNull;

public class ConfirmationCreateDto {

  @NotNull
  private Long userId;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}