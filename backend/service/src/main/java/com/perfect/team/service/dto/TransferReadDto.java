package com.perfect.team.service.dto;

import java.math.BigDecimal;

public class TransferReadDto {
    private Long id;
    private BigDecimal value;
    private String note;
    private Long date;
    private BigDecimal exchangeRate;
    private Long fromAccountId;
    private Long toAccountId;
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

    @Override
    public String toString() {
        return "TransferReadDto{" +
                "id=" + id +
                ", value=" + value +
                ", note='" + note + '\'' +
                ", date=" + date +
                ", exchangeRate=" + exchangeRate +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", userId=" + userId +
                '}';
    }
}
