package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.AccountReadDto;
import java.util.List;

public class AccountsResponse {

  @JsonProperty(value = "accounts")
  private List<AccountReadDto> accountDtos;

  public List<AccountReadDto> getAccountDtos() {
    return accountDtos;
  }

  public void setAccountDtos(List<AccountReadDto> accountDtos) {
    this.accountDtos = accountDtos;
  }
}
