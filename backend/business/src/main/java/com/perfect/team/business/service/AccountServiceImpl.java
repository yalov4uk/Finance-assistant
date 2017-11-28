package com.perfect.team.business.service;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import com.perfect.team.business.service.base.AuthCrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class AccountServiceImpl extends AuthCrudServiceBase<Account> implements AccountService {

    @Inject
    private AccountMapper accountMapper;

    @Override
    protected AuthCrudMapper<Account> getMapper() {
        return accountMapper;
    }
}
