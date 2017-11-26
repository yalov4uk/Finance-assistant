package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.AccountController;
import com.perfect.team.api.rest.request.AccountRequest;
import com.perfect.team.api.rest.response.AccountResponse;
import com.perfect.team.api.rest.response.AccountsResponse;
import com.perfect.team.impl.rest.controller.base.CrudControllerImpl;
import com.perfect.team.impl.rest.service.AccountRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(
        value = "api/v1/accounts",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AccountControllerImpl extends CrudControllerImpl<AccountRequest, AccountResponse, AccountsResponse>
        implements AccountController {

    @Inject
    private AccountRestService accountRestService;

    @Override
    protected CrudRestService<AccountRequest, AccountResponse, AccountsResponse> getCrudRestService() {
        return accountRestService;
    }
}
