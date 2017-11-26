package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.AccountDto;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.api.rest.response.AccountResponse;
import com.perfect.team.api.rest.response.AccountsResponse;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class AccountRestServiceImpl
        extends CrudRestServiceImpl<AccountRequest, Account, AccountResponse, AccountsResponse>
        implements AccountRestService {

    @Inject
    private AccountService accountService;

    @Override
    public AccountsResponse readByUserId(Long userId) {
        List<Account> accounts = accountService.readByUserId(userId);
        return mapEntitiesToListResponse(accounts);
    }

    @Override
    protected CrudService<Account> getCrudService() {
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
}
