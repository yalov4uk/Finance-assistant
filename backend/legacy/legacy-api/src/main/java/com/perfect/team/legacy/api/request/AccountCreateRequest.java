package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.AccountCreateDto;
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
