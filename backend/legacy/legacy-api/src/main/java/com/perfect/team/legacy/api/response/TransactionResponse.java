package com.perfect.team.legacy.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.TransactionReadDto;

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
