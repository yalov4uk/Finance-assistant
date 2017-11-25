package com.perfect.team.api.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class TransferDto {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "value")
    private Integer value;

    @JsonProperty(value = "note")
    private String note;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "source_account_id")
    private Long sourceAccountId;

    @JsonProperty(value = "destination_account_id")
    private Long destinationAccountId;

    @JsonProperty(value = "user")
    private Long userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
