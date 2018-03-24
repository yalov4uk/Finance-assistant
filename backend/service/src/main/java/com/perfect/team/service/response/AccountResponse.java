package com.perfect.team.service.response;

import com.perfect.team.service.dto.AccountReadDto;
import com.perfect.team.service.response.base.BaseResponse;


public class AccountResponse extends BaseResponse {
    private AccountReadDto accountReadDto;

    public AccountReadDto getAccountReadDto() {
        return accountReadDto;
    }

    public void setAccountReadDto(AccountReadDto accountReadDto) {
        this.accountReadDto = accountReadDto;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "accountReadDto=" + accountReadDto +
                "} " + super.toString();
    }
}
