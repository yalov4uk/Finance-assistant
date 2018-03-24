package com.perfect.team.service.dto;

import java.math.BigDecimal;

public class TransactionCreateDto {
    private BigDecimal value;
    private String note;
    private Long date;
    private Long categoryId;
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

    @Override
    public String toString() {
        return "TransactionCreateDto{" +
                "value=" + value +
                ", note='" + note + '\'' +
                ", date=" + date +
                ", categoryId=" + categoryId +
                ", accountId=" + accountId +
                '}';
    }
}
