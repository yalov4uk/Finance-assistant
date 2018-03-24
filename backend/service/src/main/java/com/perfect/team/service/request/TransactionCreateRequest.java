package com.perfect.team.service.request;

import com.perfect.team.service.dto.TransactionCreateDto;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.request.base.BaseRequest;

public class TransactionCreateRequest extends AuthRequest {
    private TransactionCreateDto transactionDto;

    public TransactionCreateDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionCreateDto transactionDto) {
        this.transactionDto = transactionDto;
    }

    @Override
    public String toString() {
        return "TransactionCreateRequest{" +
                "transactionDto=" + transactionDto +
                "} " + super.toString();
    }
}
