package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransactionCreateDto;

public class TransactionCreateRequest {

    @JsonProperty(value = "transaction")
    private TransactionCreateDto transactionDto;

    public TransactionCreateDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionCreateDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
