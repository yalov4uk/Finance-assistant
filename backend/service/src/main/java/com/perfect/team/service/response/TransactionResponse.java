package com.perfect.team.service.response;


import com.perfect.team.service.dto.TransactionReadDto;
import com.perfect.team.service.response.base.BaseResponse;

public class TransactionResponse extends BaseResponse {
    private TransactionReadDto transactionDto;

    public TransactionReadDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionReadDto transactionDto) {
        this.transactionDto = transactionDto;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "transactionDto=" + transactionDto +
                "} " + super.toString();
    }
}
