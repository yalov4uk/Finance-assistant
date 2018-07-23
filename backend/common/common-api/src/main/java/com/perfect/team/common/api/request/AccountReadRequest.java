package com.perfect.team.common.api.request;

import javax.validation.constraints.Pattern;
import javax.ws.rs.QueryParam;

public class AccountReadRequest {

  @QueryParam("id")
  private Long id;

  @QueryParam("name")
  private String name;

  @Pattern(regexp = "(usd)|(eur)|(byn)")
  @QueryParam("currency")
  private String currency;

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

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
