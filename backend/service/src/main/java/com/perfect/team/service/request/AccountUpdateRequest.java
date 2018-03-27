package com.perfect.team.service.request;


import com.perfect.team.service.dto.AccountUpdateDto;

public class AccountUpdateRequest extends IdRequest {

  private AccountUpdateDto accountDto;

  public AccountUpdateDto getAccountDto() {
    return accountDto;
  }

  public void setAccountDto(AccountUpdateDto accountDto) {
    this.accountDto = accountDto;
  }

  @Override
  public String toString() {
    return "AccountUpdateRequest{" +
        "accountDto=" + accountDto +
        "} " + super.toString();
  }
}
