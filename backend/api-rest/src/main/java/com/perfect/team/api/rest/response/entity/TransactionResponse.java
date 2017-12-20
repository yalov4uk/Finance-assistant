package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.TransactionOutDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class TransactionResponse {

    @JsonProperty(value = "transaction")
    private TransactionOutDto transactionDto;

    public TransactionOutDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionOutDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
