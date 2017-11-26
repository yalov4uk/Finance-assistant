package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.TransactionDto;
import com.perfect.team.api.rest.request.TransactionRequest;
import com.perfect.team.api.rest.response.TransactionResponse;
import com.perfect.team.api.rest.response.TransactionsResponse;
import com.perfect.team.business.entity.Transaction;


/**
 * Created by Denis on 25.11.2017.
 */
public interface TransactionRestService {
    TransactionsResponse findByUserId(Long id);
    TransactionResponse findById(Long id);
    TransactionResponse save(TransactionRequest transactionRequest);
    void delete(TransactionRequest transactionRequest);
}
