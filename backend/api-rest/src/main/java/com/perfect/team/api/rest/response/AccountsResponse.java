package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.AccountReadDto;

import java.util.List;

public class AccountsResponse {

    @JsonProperty(value = "accounts")
    private List<AccountReadDto> accountReadDtos;

    public List<AccountReadDto> getAccountReadDtos() {
        return accountReadDtos;
    }

    public void setAccountReadDtos(List<AccountReadDto> accountReadDtos) {
        this.accountReadDtos = accountReadDtos;
    }
}
