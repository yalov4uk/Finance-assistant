package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.TransactionRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Denis on 26.11.2017.
 */
public interface TransactionController {
    HttpEntity getAllTransactions();
    HttpEntity getById(@PathVariable("id") Long id);
    HttpEntity update(@RequestBody TransactionRequest transactionRequest);
    HttpEntity add(@RequestBody TransactionRequest transactionRequest);
    HttpEntity delete(@RequestBody TransactionRequest transactionRequest);
}
