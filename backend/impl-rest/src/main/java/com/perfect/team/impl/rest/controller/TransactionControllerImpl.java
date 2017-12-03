package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransactionController;
import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.TransactionRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller
public class TransactionControllerImpl extends CrudControllerBase<TransactionRequest> implements TransactionController {

    @Inject
    private TransactionRestService transactionRestService;

    @Override
    protected CrudRestService getService() {
        return transactionRestService;
    }
}