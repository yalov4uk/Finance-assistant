package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.AccountUpdateDto;

public class AccountUpdateRequest {

    @JsonProperty(value = "account")
    private AccountUpdateDto accountDto;

    public AccountUpdateDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountUpdateDto accountDto) {
        this.accountDto = accountDto;
    }
}
