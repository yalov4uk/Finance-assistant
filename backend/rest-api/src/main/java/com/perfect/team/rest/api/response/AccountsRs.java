package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.AccountReadDto;
import java.util.List;

public class AccountsRs {

  @JsonProperty(value = "accounts")
  private List<AccountReadDto> accountReadDtos;

  public List<AccountReadDto> getAccountReadDtos() {
    return accountReadDtos;
  }

  public void setAccountReadDtos(List<AccountReadDto> accountReadDtos) {
    this.accountReadDtos = accountReadDtos;
  }
}
