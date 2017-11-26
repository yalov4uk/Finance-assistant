package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.TransactionRequest;
import com.perfect.team.api.rest.response.TransactionResponse;
import com.perfect.team.api.rest.response.TransactionsResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;


/**
 * Created by Denis on 25.11.2017.
 */
public interface TransactionRestService
        extends CrudRestService<TransactionRequest, TransactionResponse, TransactionsResponse> {

    TransactionsResponse readByUserId(Long userId);
}
