package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransferReadDto;

import java.util.List;

public class TransfersResponse {

    @JsonProperty(value = "transfers")
    private List<TransferReadDto> transferReadDtos;

    public List<TransferReadDto> getTransferReadDtos() {
        return transferReadDtos;
    }

    public void setTransferReadDtos(List<TransferReadDto> transferReadDtos) {
        this.transferReadDtos = transferReadDtos;
    }
}
