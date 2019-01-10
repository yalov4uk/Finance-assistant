package com.perfect.team.legacy.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.AccountReadDto;

public class AccountResponse {

  @JsonProperty(value = "account")
  private AccountReadDto accountDto;

  public AccountReadDto getAccountDto() {
    return accountDto;
  }

  public void setAccountDto(AccountReadDto accountDto) {
    this.accountDto = accountDto;
  }
}