package com.perfect.team.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignInRequest {

  @NotNull
  @Valid
  @JsonProperty("signIn")
  private SignInDto signInDto;
}
