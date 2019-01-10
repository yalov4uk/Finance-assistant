package com.perfect.team.legacy.api.dto;

import javax.validation.constraints.Pattern;

public class AccountUpdateDto {

  private String name;

  private String icon;

  @Pattern(regexp = "(usd)|(eur)|(byn)")
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
