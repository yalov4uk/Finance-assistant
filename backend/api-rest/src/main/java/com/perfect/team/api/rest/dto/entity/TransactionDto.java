package com.perfect.team.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class TransactionDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "value")
    private Integer value;

    @JsonProperty(value = "note")
    private String note;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "category_id")
    private Long categoryId;

    @JsonProperty(value = "account_id")
    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
