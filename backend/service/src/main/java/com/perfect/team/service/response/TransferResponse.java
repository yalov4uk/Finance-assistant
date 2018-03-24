package com.perfect.team.service.response;

import com.perfect.team.service.dto.TransferReadDto;
import com.perfect.team.service.response.base.BaseResponse;

public class TransferResponse extends BaseResponse {
    private TransferReadDto transferReadDto;

    public TransferReadDto getTransferReadDto() {
        return transferReadDto;
    }

    public void setTransferReadDto(TransferReadDto transferReadDto) {
        this.transferReadDto = transferReadDto;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "transferReadDto=" + transferReadDto +
                "} " + super.toString();
    }
}
