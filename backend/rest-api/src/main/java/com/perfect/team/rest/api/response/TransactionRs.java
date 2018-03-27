package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.TransactionReadDto;

public class TransactionRs {

  @JsonProperty(value = "transaction")
  private TransactionReadDto transactionDto;

  public TransactionReadDto getTransactionDto() {
    return transactionDto;
  }

  public void setTransactionDto(TransactionReadDto transactionDto) {
    this.transactionDto = transactionDto;
  }
}
