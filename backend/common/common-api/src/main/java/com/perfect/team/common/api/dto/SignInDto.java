package com.perfect.team.common.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignInDto {

  @NotNull
  private String username;

  @NotNull
  private String password;

  @Pattern(regexp = "(email)")
  @NotNull
  private String type;

  public SignInDto() {
  }

  public SignInDto(String username, String password, String type) {
    this.username = username;
    this.password = password;
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
