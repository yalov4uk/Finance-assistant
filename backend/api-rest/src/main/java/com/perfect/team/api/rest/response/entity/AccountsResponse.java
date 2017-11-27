package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.AccountDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public class AccountsResponse {

    @JsonProperty(value = "accounts")
    private List<AccountDto> accountDtos;

    public List<AccountDto> getAccountDtos() {
        return accountDtos;
    }

    public void setAccountDtos(List<AccountDto> accountDtos) {
        this.accountDtos = accountDtos;
    }
}
