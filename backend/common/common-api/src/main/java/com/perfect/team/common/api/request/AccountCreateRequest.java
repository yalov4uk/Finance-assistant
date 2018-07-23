package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.AccountCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountCreateRequest {

  @NotNull
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
