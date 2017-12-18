package com.perfect.team.api.rest.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "value")
    private BigDecimal value;

    @JsonProperty(value = "note")
    private String note;

    @JsonProperty(value = "date")
    private Long date;

    @JsonProperty(value = "userId")
    private Long userId;

    @JsonProperty(value = "categoryId")
    private Long categoryId;

    @JsonProperty(value = "accountId")
    private Long accountId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
