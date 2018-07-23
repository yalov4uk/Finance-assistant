package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.SignInDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SignInRequest {

  @NotNull
  @Valid
  @JsonProperty("signIn")
  private SignInDto signInDto;

  public SignInRequest() {
  }

  public SignInRequest(SignInDto signInDto) {
    this.signInDto = signInDto;
  }

  public SignInDto getSignInDto() {
    return signInDto;
  }

  public void setSignInDto(SignInDto signInDto) {
    this.signInDto = signInDto;
  }
}
