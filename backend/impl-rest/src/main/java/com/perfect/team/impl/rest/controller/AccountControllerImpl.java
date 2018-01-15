package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.AccountController;
import com.perfect.team.api.rest.request.entity.AccountRequest;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.AccountRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;

import javax.inject.Inject;

public class AccountControllerImpl extends CrudControllerBase<AccountRequest> implements AccountController {

    @Inject
    private AccountRestService accountRestService;

    @Override
    protected CrudRestService getService() {
        return accountRestService;
    }
}
