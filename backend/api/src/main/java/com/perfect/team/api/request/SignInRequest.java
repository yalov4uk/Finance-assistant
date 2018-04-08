package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.SignInDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SignInRequest {

  @NotNull
  @Valid
  @JsonProperty("signIn")
  private SignInDto signInDto;

  public SignInDto getSignInDto() {
    return signInDto;
  }

  public void setSignInDto(SignInDto signInDto) {
    this.signInDto = signInDto;
  }
}
