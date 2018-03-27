package com.perfect.team.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserReadDto {

  @JsonProperty(value = "id")
  private Long id;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "email")
  private String email;

  @JsonProperty(value = "password")
  private String password;

  public UserReadDto() {
  }

  public UserReadDto(String name, String email) {
    this.name = name;
    this.email = email;
  }

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
}
