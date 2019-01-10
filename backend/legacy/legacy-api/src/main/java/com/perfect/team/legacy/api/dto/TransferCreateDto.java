package com.perfect.team.legacy.api.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class TransferCreateDto {

  @DecimalMin("0")
  @NotNull
  private BigDecimal value;

  private String note;

  private Long date;

  private BigDecimal exchangeRate;

  @NotNull
  private Long fromAccountId;

  @NotNull
  private Long toAccountId;

  @NotNull
  private Long userId;

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

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public Long getFromAccountId() {
    return fromAccountId;
  }

  public void setFromAccountId(Long fromAccountId) {
    this.fromAccountId = fromAccountId;
  }

  public Long getToAccountId() {
    return toAccountId;
  }

  public void setToAccountId(Long toAccountId) {
    this.toAccountId = toAccountId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
