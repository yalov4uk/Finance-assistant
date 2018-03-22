package com.perfect.team.service.request;

import com.perfect.team.service.dto.TransactionCreateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class TransactionCreateRequest extends BaseRequest {
    private TransactionCreateDto transactionDto;

    public TransactionCreateDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionCreateDto transactionDto) {
        this.transactionDto = transactionDto;
    }
}
