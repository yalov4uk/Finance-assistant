package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.TransactionUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransactionUpdateRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "transaction")
  private TransactionUpdateDto transactionDto;

  public TransactionUpdateDto getTransactionDto() {
    return transactionDto;
  }

  public void setTransactionDto(TransactionUpdateDto transactionDto) {
    this.transactionDto = transactionDto;
  }
}
