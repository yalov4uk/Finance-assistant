package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.AccountDto;
import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.api.rest.response.AccountResponse;
import com.perfect.team.api.rest.response.AccountsResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.Account;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class AccountRestServiceImpl extends CrudRestServiceImpl implements AccountRestService {
    @Inject
    private AccountService accountService;

    @Override
    public AccountsResponse findByUserId(Long id) {
        List<Account> accounts = accountService.findByUserId(id);
        AccountsResponse accountResponse = new AccountsResponse();
        accountResponse.setAccountDtos(accounts
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList()));
        return accountResponse;
    }

    @Override
    public AccountResponse save(AccountRequest accountRequest) {
        Account account = modelMapper.map(accountRequest.getAccountDto(), Account.class);
        account = accountService.save(account);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountDto(modelMapper.map(account, AccountDto.class));
        return accountResponse;
    }

}
