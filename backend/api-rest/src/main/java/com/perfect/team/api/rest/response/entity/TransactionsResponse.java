package com.perfect.team.api.rest.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.TransactionOutDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public class TransactionsResponse {

    @JsonProperty(value = "transactions")
    private List<TransactionOutDto> transactionDtos;

    public List<TransactionOutDto> getTransactionDtos() {
        return transactionDtos;
    }

    public void setTransactionDtos(List<TransactionOutDto> transactionDtos) {
        this.transactionDtos = transactionDtos;
    }
}
