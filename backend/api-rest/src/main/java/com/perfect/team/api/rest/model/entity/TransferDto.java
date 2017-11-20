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

    @JsonProperty(value = "source_account")
    private AccountDto sourceAccountDto;

    @JsonProperty(value = "destination_account")
    private AccountDto destinationAccountDto;

    @JsonProperty(value = "user")
    private UserDto userDto;

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

    public AccountDto getSourceAccountDto() {
        return sourceAccountDto;
    }

    public void setSourceAccountDto(AccountDto sourceAccountDto) {
        this.sourceAccountDto = sourceAccountDto;
    }

    public AccountDto getDestinationAccountDto() {
        return destinationAccountDto;
    }

    public void setDestinationAccountDto(AccountDto destinationAccountDto) {
        this.destinationAccountDto = destinationAccountDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
