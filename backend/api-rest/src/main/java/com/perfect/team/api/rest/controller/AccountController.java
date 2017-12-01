package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.entity.AccountResponse;
import com.perfect.team.api.rest.response.entity.AccountsResponse;

/**
 * Created by Denis on 26.11.2017.
 */
public interface AccountController extends AuthCrudController<AccountRequest, AccountResponse, AccountsResponse> {
}
