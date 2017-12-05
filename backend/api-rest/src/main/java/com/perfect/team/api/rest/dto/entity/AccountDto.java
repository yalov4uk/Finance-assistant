package com.perfect.team.api.rest.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "icon")
    private String icon;

    @JsonProperty(value = "balance")
    private long balance;

    @JsonProperty(value = "initialDate")
    private Long initialDate;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "userId")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Long getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Long initialDate) {
        this.initialDate = initialDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
