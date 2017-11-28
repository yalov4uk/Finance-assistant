package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.AccountDto;
import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.entity.AccountResponse;
import com.perfect.team.api.rest.response.entity.AccountsResponse;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.business.service.base.AuthCrudService;
import com.perfect.team.impl.rest.service.base.AuthCrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
@Transactional
public class AccountRestServiceImpl
        extends AuthCrudRestServiceBase<AccountRequest, Account, AccountResponse, AccountsResponse>
        implements AccountRestService {

    @Inject
    private AccountService accountService;

    @Override
    protected AuthCrudService<Account> getCrudService() {
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
