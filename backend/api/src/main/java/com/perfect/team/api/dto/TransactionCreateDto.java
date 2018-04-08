package com.perfect.team.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class TransactionCreateDto {

  @DecimalMin("0")
  @NotNull
  @JsonProperty(value = "value")
  private BigDecimal value;

  @JsonProperty(value = "note")
  private String note;

  @JsonProperty(value = "date")
  private Long date;

  @NotNull
  @JsonProperty(value = "categoryId")
  private Long categoryId;

  @NotNull
  @JsonProperty(value = "accountId")
  private Long accountId;

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

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
}
