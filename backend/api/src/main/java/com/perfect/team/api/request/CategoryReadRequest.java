package com.perfect.team.api.request;

import javax.validation.constraints.Pattern;
import javax.ws.rs.QueryParam;

public class CategoryReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("userId")
  private Long userId;

  @Pattern(regexp = "(income)|(outcome)")
  @QueryParam("type")
  private String type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
