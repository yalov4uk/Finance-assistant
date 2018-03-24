package com.perfect.team.service.dto;

import java.math.BigDecimal;

public class TransactionUpdateDto {
    private BigDecimal value;
    private String note;
    private Long date;
    private CategoryReadDto category;
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

    public CategoryReadDto getCategory() {
        return category;
    }

    public void setCategory(CategoryReadDto category) {
        this.category = category;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "TransactionUpdateDto{" +
                "value=" + value +
                ", note='" + note + '\'' +
                ", date=" + date +
                ", category=" + category +
                ", accountId=" + accountId +
                '}';
    }
}
