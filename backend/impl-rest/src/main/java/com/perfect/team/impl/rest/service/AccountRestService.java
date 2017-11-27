package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.entity.AccountResponse;
import com.perfect.team.api.rest.response.entity.AccountsResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface AccountRestService extends CrudRestService<AccountRequest, AccountResponse, AccountsResponse> {

    AccountsResponse readByUserId(Long userId);
}
