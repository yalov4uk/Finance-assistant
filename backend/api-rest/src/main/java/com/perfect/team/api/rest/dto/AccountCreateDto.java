package com.perfect.team.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountCreateDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "icon")
    private String icon;

    @JsonProperty(value = "balance")
    private BigDecimal balance;

    @JsonProperty(value = "initialDate")
    private Long initialDate;

    @JsonProperty(value = "currency")
    private String currency;

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
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
}
