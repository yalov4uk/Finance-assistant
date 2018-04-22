package com.perfect.team.api.request;

import javax.ws.rs.QueryParam;

public class UserReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("name")
  private String name;

  @QueryParam("email")
  private String email;

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
}
