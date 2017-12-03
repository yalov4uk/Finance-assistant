package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.AccountDto;
import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.entity.AccountResponse;
import com.perfect.team.api.rest.response.entity.AccountsResponse;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.auth.AccountAuthService;
import com.perfect.team.business.service.custom.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountRestServiceImpl
        extends CrudRestServiceBase<AccountRequest, Account, AccountResponse, AccountsResponse>
        implements AccountRestService {

    @Inject
    private AccountAuthService accountService;

    @Override
    protected CrudService<Account> getService() {
        return accountService;
    }

    @Override
    protected Account mapRequestToEntity(AccountRequest accountRequest) {
        return modelMapper.map(accountRequest.getAccountDto(), Account.class);
    }

    @Override
    protected AccountResponse mapEntityToResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountDto(modelMapper.map(account, AccountDto.class));
        return accountResponse;
    }

    @Override
    protected AccountsResponse mapEntitiesToListResponse(List<Account> accounts) {
        AccountsResponse accountsResponse = new AccountsResponse();
        accountsResponse.setAccountDtos(accounts
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList()));
        return accountsResponse;
    }

    @Override
    protected String getEntityPath() {
        return "accounts/";
    }
}
