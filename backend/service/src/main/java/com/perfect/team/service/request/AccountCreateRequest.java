package com.perfect.team.service.request;


import com.perfect.team.service.dto.AccountCreateDto;
import com.perfect.team.service.request.base.AuthRequest;

public class AccountCreateRequest extends AuthRequest {

  private AccountCreateDto accountDto;

  public AccountCreateDto getAccountDto() {
    return accountDto;
  }

  public void setAccountDto(AccountCreateDto accountDto) {
    this.accountDto = accountDto;
  }

  @Override
  public String toString() {
    return "AccountCreateRequest{" +
        "accountDto=" + accountDto +
        "} " + super.toString();
  }
}
