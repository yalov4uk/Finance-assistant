package com.perfect.team.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Account implements Serializable {

  private Long id;

  private String name;

  private String icon;

  private BigDecimal balance;

  private Date initialDate;

  private Currency currency;

  private User user;

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

  public Date getInitialDate() {
    return initialDate;
  }

  public void setInitialDate(Date initialDate) {
    this.initialDate = initialDate;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Account)) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(name, account.name) &&
        Objects.equals(icon, account.icon) &&
        Objects.equals(balance, account.balance) &&
        Objects.equals(currency, account.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, icon, balance, currency);
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", icon='" + icon + '\'' +
        ", balance=" + balance +
        ", initialDate=" + initialDate +
        ", currency='" + currency + '\'' +
        '}';
  }

  public enum Currency {
    USD, EUR, BYN,
  }
}
