package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.SignUpDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SignUpRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "user")
  private SignUpDto signUpDto;

  public SignUpDto getSignUpDto() {
    return signUpDto;
  }

  public void setSignUpDto(SignUpDto signUpDto) {
    this.signUpDto = signUpDto;
  }
}
