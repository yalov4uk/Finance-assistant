package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.AccountReadDto;

public class AccountResponse {

    @JsonProperty(value = "account")
    private AccountReadDto accountReadDto;

    public AccountReadDto getAccountReadDto() {
        return accountReadDto;
    }

    public void setAccountReadDto(AccountReadDto accountReadDto) {
        this.accountReadDto = accountReadDto;
    }
}
