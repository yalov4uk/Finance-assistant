package com.perfect.team.service.impl;

import com.perfect.team.service.api.AccountService;
import com.perfect.team.service.request.AccountCreateRequest;
import com.perfect.team.service.request.AccountUpdateRequest;
import com.perfect.team.service.response.AccountResponse;
import com.perfect.team.service.response.AccountsResponse;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public URI create(AccountCreateRequest request) {
        return null;
    }

    @Override
    public AccountResponse read(Long id) {
        return null;
    }

    @Override
    public AccountResponse update(Long id, AccountUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AccountsResponse readAll() {
        return null;
    }
}
