package com.perfect.team.service.dto;

public class AccountUpdateDto {

  private String name;
  private String icon;
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

  @Override
  public String toString() {
    return "AccountUpdateDto{" +
        "name='" + name + '\'' +
        ", icon='" + icon + '\'' +
        ", currency='" + currency + '\'' +
        '}';
  }
}
