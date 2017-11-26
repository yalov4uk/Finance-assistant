package com.perfect.team.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class TransferDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "value")
    private Integer value;

    @JsonProperty(value = "note")
    private String note;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "from_account_id")
    private Long fromAccountId;

    @JsonProperty(value = "to_account_id")
    private Long toAccountId;

    @JsonProperty(value = "user_id")
    private Long userId;

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