package com.perfect.team.service.request;


import com.perfect.team.service.dto.TransferCreateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class TransferCreateRequest extends BaseRequest {
    private TransferCreateDto transferDto;

    public TransferCreateDto getTransferDto() {
        return transferDto;
    }

    public void setTransferDto(TransferCreateDto transferDto) {
        this.transferDto = transferDto;
    }
}
