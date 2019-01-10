package com.perfect.team.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Serializable {

  private Long id;

  private BigDecimal value;

  private String note;

  private Date date;

  private User user;

  private Category category;

  private Account account;

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Transaction)) {
      return false;
    }
    Transaction that = (Transaction) o;
    return Objects.equals(value, that.value) &&
        Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, note);
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "id=" + id +
        ", value=" + value +
        ", note='" + note + '\'' +
        ", date=" + date +
        '}';
  }
}
