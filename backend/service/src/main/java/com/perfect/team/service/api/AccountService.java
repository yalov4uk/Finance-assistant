package com.perfect.team.service.api;

import com.perfect.team.service.request.AccountCreateRequest;
import com.perfect.team.service.request.AccountUpdateRequest;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.AccountResponse;
import com.perfect.team.service.response.AccountsResponse;
import com.perfect.team.service.validation.AccountCreate;
import com.perfect.team.service.validation.AccountId;
import com.perfect.team.service.validation.AccountUpdate;
import org.springframework.validation.annotation.Validated;

import java.net.URI;

@Validated
public interface AccountService {
    URI create(@AccountCreate AccountCreateRequest request);

    AccountResponse read(@AccountId IdRequest request);

    AccountResponse update(@AccountUpdate AccountUpdateRequest request);

    void delete(@AccountId IdRequest request);

    AccountsResponse readAll(AuthRequest request);
}
