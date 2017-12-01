package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.AuthCrudController;
import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.api.rest.response.entity.TransactionResponse;
import com.perfect.team.api.rest.response.entity.TransactionsResponse;

/**
 * Created by Denis on 26.11.2017.
 */
public interface TransactionController extends AuthCrudController<TransactionRequest, TransactionResponse, TransactionsResponse> {
}
