package com.perfect.team.service.request;


import com.perfect.team.service.dto.TransferUpdateDto;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.request.base.BaseRequest;

public class TransferUpdateRequest extends AuthRequest {
    private TransferUpdateDto transferDto;

    public TransferUpdateDto getTransferDto() {
        return transferDto;
    }

    public void setTransferDto(TransferUpdateDto transferDto) {
        this.transferDto = transferDto;
    }

    @Override
    public String toString() {
        return "TransferUpdateRequest{" +
                "transferDto=" + transferDto +
                "} " + super.toString();
    }
}
