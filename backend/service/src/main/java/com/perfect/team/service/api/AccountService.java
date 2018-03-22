package com.perfect.team.service.api;

import com.perfect.team.service.request.AccountCreateRequest;
import com.perfect.team.service.request.AccountUpdateRequest;
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

    AccountResponse read(@AccountId Long id);

    AccountResponse update(@AccountId Long id, @AccountUpdate AccountUpdateRequest request);

    void delete(@AccountId Long id);

    AccountsResponse readAll();
}
