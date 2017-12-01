package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.api.rest.response.entity.AccountResponse;
import com.perfect.team.api.rest.response.entity.AccountsResponse;

import javax.ws.rs.Path;

/**
 * Created by Denis on 26.11.2017.
 */
@Path("/accounts")
public interface AccountController extends AuthCrudController<AccountRequest, AccountResponse, AccountsResponse> {
}
