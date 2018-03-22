package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.AccountCreateDto;
import com.perfect.team.api.rest.request.base.BaseRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountCreateRequest extends BaseRequest {

    @NotNull(message = "hahah")
    @Valid
    @JsonProperty(value = "account")
    private AccountCreateDto accountDto;

    public AccountCreateDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountCreateDto accountDto) {
        this.accountDto = accountDto;
    }
}
