package com.perfect.team.legacy.api.request;

import javax.validation.constraints.Pattern;
import javax.ws.rs.QueryParam;

public class CategoryReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("name")
  private String name;

  @Pattern(regexp = "(income)|(outcome)")
  @QueryParam("type")
  private String type;

  @QueryParam("userId")
  private Long userId;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
