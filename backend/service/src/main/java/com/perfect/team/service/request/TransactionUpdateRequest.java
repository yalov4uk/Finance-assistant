package com.perfect.team.service.request;


import com.perfect.team.service.dto.TransactionUpdateDto;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.request.base.BaseRequest;

public class TransactionUpdateRequest extends AuthRequest {
    private TransactionUpdateDto transactionDto;

    public TransactionUpdateDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionUpdateDto transactionDto) {
        this.transactionDto = transactionDto;
    }

    @Override
    public String toString() {
        return "TransactionUpdateRequest{" +
                "transactionDto=" + transactionDto +
                "} " + super.toString();
    }
}
