package com.perfect.team.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountUpdateDto {

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "icon")
  private String icon;

  @JsonProperty(value = "currency")
  private String currency;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
