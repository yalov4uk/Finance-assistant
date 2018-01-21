package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.AccountCreateDto;

public class AccountCreateRequest {

    @JsonProperty(value = "account")
    private AccountCreateDto accountDto;

    public AccountCreateDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountCreateDto accountDto) {
        this.accountDto = accountDto;
    }
}
