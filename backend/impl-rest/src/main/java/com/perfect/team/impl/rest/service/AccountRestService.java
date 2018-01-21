package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.AccountResponse;
import com.perfect.team.api.rest.response.AccountsResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface AccountRestService extends CrudRestService<AccountRequest, AccountResponse, AccountsResponse> {
}
