package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.AccountUpdateDto;
import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountUpdateRequest {

  @NotNull
  @AtLeastOneNotNull(fieldNames = {"name", "icon", "currency"})
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
