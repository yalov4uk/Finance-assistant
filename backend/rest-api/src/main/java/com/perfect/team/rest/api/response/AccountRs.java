package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.AccountReadDto;

public class AccountRs {

  @JsonProperty(value = "account")
  private AccountReadDto accountReadDto;

  public AccountReadDto getAccountReadDto() {
    return accountReadDto;
  }

  public void setAccountReadDto(AccountReadDto accountReadDto) {
    this.accountReadDto = accountReadDto;
  }
}
