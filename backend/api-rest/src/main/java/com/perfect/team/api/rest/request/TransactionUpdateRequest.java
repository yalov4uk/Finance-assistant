package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransactionUpdateDto;

public class TransactionUpdateRequest {

    @JsonProperty(value = "transaction")
    private TransactionUpdateDto transactionDto;

    public TransactionUpdateDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionUpdateDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
