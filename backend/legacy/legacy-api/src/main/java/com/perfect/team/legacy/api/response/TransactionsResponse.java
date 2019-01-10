package com.perfect.team.legacy.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.TransactionReadDto;
import java.util.List;

public class TransactionsResponse {

  @JsonProperty(value = "transactions")
  private List<TransactionReadDto> transactionDtos;

  public List<TransactionReadDto> getTransactionDtos() {
    return transactionDtos;
  }

  public void setTransactionDtos(List<TransactionReadDto> transactionDtos) {
    this.transactionDtos = transactionDtos;
  }
}
