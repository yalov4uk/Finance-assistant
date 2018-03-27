package com.perfect.team.service.response;


import com.perfect.team.service.dto.TransactionReadDto;
import com.perfect.team.service.response.base.BaseResponse;
import java.util.List;

public class TransactionsResponse extends BaseResponse {

  private List<TransactionReadDto> transactionDtos;

  public List<TransactionReadDto> getTransactionDtos() {
    return transactionDtos;
  }

  public void setTransactionDtos(List<TransactionReadDto> transactionDtos) {
    this.transactionDtos = transactionDtos;
  }

  @Override
  public String toString() {
    return "TransactionsResponse{" +
        "transactionDtos=" + transactionDtos +
        "} " + super.toString();
  }
}
