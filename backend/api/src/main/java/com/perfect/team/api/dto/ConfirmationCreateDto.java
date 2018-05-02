package com.perfect.team.api.dto;

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
