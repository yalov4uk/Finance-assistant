package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.api.rest.response.entity.TransactionResponse;
import com.perfect.team.api.rest.response.entity.TransactionsResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface TransactionRestService
        extends CrudRestService<TransactionRequest, TransactionResponse, TransactionsResponse> {
}
