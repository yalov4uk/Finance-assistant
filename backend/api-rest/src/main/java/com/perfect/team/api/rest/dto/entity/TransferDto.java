package com.perfect.team.api.rest.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransferDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "value")
    private BigDecimal value;

    @JsonProperty(value = "note")
    private String note;

    @JsonProperty(value = "date")
    private Long date;

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
