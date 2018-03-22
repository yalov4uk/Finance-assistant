package com.perfect.team.service.response;

import com.perfect.team.service.dto.TransferReadDto;
import com.perfect.team.service.response.base.BaseResponse;

import java.util.List;

public class TransfersResponse extends BaseResponse {
    private List<TransferReadDto> transferReadDtos;

    public List<TransferReadDto> getTransferReadDtos() {
        return transferReadDtos;
    }

    public void setTransferReadDtos(List<TransferReadDto> transferReadDtos) {
        this.transferReadDtos = transferReadDtos;
    }
}
