package com.perfect.team.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Transfer implements Serializable {

  private Long id;

  private BigDecimal value;

  private String note;

  private Date date;

  private BigDecimal exchangeRate;

  private Account fromAccount;

  private Account toAccount;

  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public Account getFromAccount() {
    return fromAccount;
  }

  public void setFromAccount(Account fromAccount) {
    this.fromAccount = fromAccount;
  }

  public Account getToAccount() {
    return toAccount;
  }

  public void setToAccount(Account toAccount) {
    this.toAccount = toAccount;
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
    if (!(o instanceof Transfer)) {
      return false;
    }
    Transfer transfer = (Transfer) o;
    return Objects.equals(value, transfer.value) &&
        Objects.equals(note, transfer.note) &&
        Objects.equals(exchangeRate, transfer.exchangeRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, exchangeRate);
  }

  @Override
  public String toString() {
    return "Transfer{" +
        "id=" + id +
        ", value=" + value +
        ", note='" + note + '\'' +
        ", date=" + date +
        ", exchangeRate=" + exchangeRate +
        '}';
  }
}
