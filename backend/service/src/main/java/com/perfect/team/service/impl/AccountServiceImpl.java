package com.perfect.team.service.impl;

import com.perfect.team.service.api.AccountService;
import com.perfect.team.service.request.AccountCreateRequest;
import com.perfect.team.service.request.AccountUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.AccountResponse;
import com.perfect.team.service.response.AccountsResponse;
import java.net.URI;
import org.springframework.stereotype.Service;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

  @Override
  public URI create(AccountCreateRequest request) {
    return null;
  }

  @Override
  public AccountResponse read(IdRequest request) {
    return null;
  }

  @Override
  public AccountResponse update(AccountUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(IdRequest request) {

  }

  @Override
  public AccountsResponse readAll(AuthRequest request) {
    return null;
  }
}
