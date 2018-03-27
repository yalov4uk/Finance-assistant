package com.perfect.team.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpDto {

  @JsonProperty(value = "id")
  private Long id;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "email")
  private String email;

  @JsonProperty(value = "password")
  private String password;

  @JsonProperty(value = "passwordConfirmation")
  private String passwordConfirmation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  public void setPasswordConfirmation(String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
  }
}
