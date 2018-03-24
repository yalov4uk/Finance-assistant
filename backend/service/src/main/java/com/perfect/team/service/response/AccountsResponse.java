package com.perfect.team.service.response;


import com.perfect.team.service.dto.AccountReadDto;
import com.perfect.team.service.response.base.BaseResponse;

import java.util.List;

public class AccountsResponse extends BaseResponse {
    private List<AccountReadDto> accountReadDtos;

    public List<AccountReadDto> getAccountReadDtos() {
        return accountReadDtos;
    }

    public void setAccountReadDtos(List<AccountReadDto> accountReadDtos) {
        this.accountReadDtos = accountReadDtos;
    }

    @Override
    public String toString() {
        return "AccountsResponse{" +
                "accountReadDtos=" + accountReadDtos +
                "} " + super.toString();
    }
}
