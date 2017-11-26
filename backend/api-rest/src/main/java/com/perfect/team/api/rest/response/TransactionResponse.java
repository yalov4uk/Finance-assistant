package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.model.entity.TransactionDto;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public class TransactionResponse {
    @JsonProperty(value = "transaction")
    private TransactionDto transactionDto;

    public TransactionDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
