package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.TransactionCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransactionCreateRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "transaction")
  private TransactionCreateDto transactionDto;

  public TransactionCreateDto getTransactionDto() {
    return transactionDto;
  }

  public void setTransactionDto(TransactionCreateDto transactionDto) {
    this.transactionDto = transactionDto;
  }
}
