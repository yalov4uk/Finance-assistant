package com.perfect.team.api.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class ConfirmationUpdateDto {

  @NotNull
  private String code;

  @NotNull
  @AssertTrue
  private Boolean confirmed;

  @NotNull
  private Long userId;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
