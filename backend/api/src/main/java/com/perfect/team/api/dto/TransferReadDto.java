package com.perfect.team.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class TransferReadDto {

  @JsonProperty(value = "id")
  private Long id;

  @JsonProperty(value = "value")
  private BigDecimal value;

  @JsonProperty(value = "note")
  private String note;

  @JsonProperty(value = "date")
  private Long date;

  @JsonProperty(value = "exchangeRate")
  private BigDecimal exchangeRate;

  @JsonProperty(value = "fromAccountId")
  private Long fromAccountId;

  @JsonProperty(value = "toAccountId")
  private Long toAccountId;

  @JsonProperty(value = "userId")
  private Long userId;

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
