package com.perfect.team.api.rest.request.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.TransactionInDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class TransactionRequest {

    @JsonProperty(value = "transaction")
    private TransactionInDto transactionDto;

    public TransactionInDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionInDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
