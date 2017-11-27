package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.TransactionController;
import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.api.rest.response.entity.TransactionResponse;
import com.perfect.team.api.rest.response.entity.TransactionsResponse;
import com.perfect.team.impl.rest.controller.base.CrudControllerImpl;
import com.perfect.team.impl.rest.service.TransactionRestService;
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
        value = "api/v1/transactions",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class TransactionControllerImpl
        extends CrudControllerImpl<TransactionRequest, TransactionResponse, TransactionsResponse>
        implements TransactionController {

    @Inject
    private TransactionRestService transactionRestService;

    @Override
    protected CrudRestService<TransactionRequest, TransactionResponse, TransactionsResponse> getCrudRestService() {
        return transactionRestService;
    }
}