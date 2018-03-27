package com.perfect.team.rest.api.request;

import javax.validation.constraints.Pattern;

public class SignInRq {

  @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
  private String email;

  @Pattern(regexp = ".{2,}")
  private String password;

  private String token;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
