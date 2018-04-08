package com.perfect.team.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.TransactionReadDto;

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
