package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.AccountDto;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.api.rest.response.AccountResponse;
import com.perfect.team.api.rest.response.AccountsResponse;


/**
 * Created by Denis on 25.11.2017.
 */
public interface AccountRestService {
    AccountsResponse findByUserId(Long id);
    AccountResponse findById(Long id);
    AccountResponse save(AccountRequest accountRequest);
    void delete(AccountRequest accountRequest);
}
