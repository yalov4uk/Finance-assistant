package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.model.entity.TransactionDto;
import com.perfect.team.api.rest.model.entity.UserDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public class TransactionsResponse {

    @JsonProperty(value = "transactions")
    private List<TransactionDto> transactionDtos;

    public List<TransactionDto> getTransactionDtos() {
        return transactionDtos;
    }

    public void setTransactionDtos(List<TransactionDto> transactionDtos) {
        this.transactionDtos = transactionDtos;
    }

}