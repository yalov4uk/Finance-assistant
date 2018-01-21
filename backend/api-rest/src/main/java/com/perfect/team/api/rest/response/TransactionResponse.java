package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransactionReadDto;

public class TransactionResponse {

    @JsonProperty(value = "transaction")
    private TransactionReadDto transactionDto;

    public TransactionReadDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionReadDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
