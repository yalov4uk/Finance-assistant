package com.perfect.team.service.dto;

import java.math.BigDecimal;

public class TransferCreateDto {

  private BigDecimal value;
  private String note;
  private Long date;
  private BigDecimal exchangeRate;
  private Long toAccountId;

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

  public Long getToAccountId() {
    return toAccountId;
  }

  public void setToAccountId(Long toAccountId) {
    this.toAccountId = toAccountId;
  }

  @Override
  public String toString() {
    return "TransferCreateDto{" +
        "value=" + value +
        ", note='" + note + '\'' +
        ", date=" + date +
        ", exchangeRate=" + exchangeRate +
        ", toAccountId=" + toAccountId +
        '}';
  }
}
