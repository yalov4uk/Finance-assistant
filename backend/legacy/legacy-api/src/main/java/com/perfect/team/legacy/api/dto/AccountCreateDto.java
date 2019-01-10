package com.perfect.team.legacy.api.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccountCreateDto {

  @NotNull
  private String name;

  private String icon;

  @DecimalMin("0")
  @NotNull
  private BigDecimal balance;

  private Long initialDate;

  @Pattern(regexp = "(usd)|(eur)|(byn)")
  @NotNull
  private String currency;

  private Long userId;

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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
