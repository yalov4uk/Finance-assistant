package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.SignUpDto;

public class SignUpRq {

  @JsonProperty(value = "user")
  private SignUpDto signUpDto;

  public SignUpDto getSignUpDto() {
    return signUpDto;
  }

  public void setSignUpDto(SignUpDto signUpDto) {
    this.signUpDto = signUpDto;
  }
}
