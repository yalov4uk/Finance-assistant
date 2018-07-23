package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.AccountReadDto;
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
