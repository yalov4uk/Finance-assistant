package com.perfect.team.auth.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignInDto {

  @NotNull
  private String username;

  @NotNull
  private String password;
}
