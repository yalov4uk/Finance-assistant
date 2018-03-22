package com.perfect.team.service.request;


import com.perfect.team.service.dto.AccountUpdateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class AccountUpdateRequest extends BaseRequest {
    private AccountUpdateDto accountDto;

    public AccountUpdateDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountUpdateDto accountDto) {
        this.accountDto = accountDto;
    }
}
