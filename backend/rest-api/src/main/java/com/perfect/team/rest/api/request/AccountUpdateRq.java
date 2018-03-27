package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.AccountUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountUpdateRq {

  @NotNull
  @Valid
  @JsonProperty(value = "account")
  private AccountUpdateDto accountDto;

  public AccountUpdateDto getAccountDto() {
    return accountDto;
  }

  public void setAccountDto(AccountUpdateDto accountDto) {
    this.accountDto = accountDto;
  }
}
