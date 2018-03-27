package com.perfect.team.service.dto;

public class SignInDto {

  private String email;
  private String password;
  private String token;
  private String method;

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

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public String toString() {
    return "SignInDto{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", token='" + token + '\'' +
        ", method='" + method + '\'' +
        '}';
  }
}
