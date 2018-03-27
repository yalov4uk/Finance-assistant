package com.perfect.team.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class TransferCreateDto {

  @DecimalMin("0")
  @NotNull
  @JsonProperty(value = "value")
  private BigDecimal value;

  @JsonProperty(value = "note")
  private String note;

  @JsonProperty(value = "date")
  private Long date;

  @JsonProperty(value = "exchangeRate")
  private BigDecimal exchangeRate;

  @NotNull
  @JsonProperty(value = "toAccountId")
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
}
