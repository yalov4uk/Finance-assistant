package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.AccountDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class AccountResponse {

    @JsonProperty(value = "account")
    private AccountDto accountDto;

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
