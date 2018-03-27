package com.perfect.team.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class AccountCreateDto {

  @NotNull
  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "icon")
  private String icon;

  @DecimalMin("0")
  @NotNull
  @JsonProperty(value = "balance")
  private BigDecimal balance;

  @JsonProperty(value = "initialDate")
  private Long initialDate;

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

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public Long getInitialDate() {
    return initialDate;
  }

  public void setInitialDate(Long initialDate) {
    this.initialDate = initialDate;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
