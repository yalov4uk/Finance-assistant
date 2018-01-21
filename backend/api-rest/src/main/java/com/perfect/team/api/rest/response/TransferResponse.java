package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransferReadDto;

public class TransferResponse {

    @JsonProperty(value = "transfer")
    private TransferReadDto transferReadDto;

    public TransferReadDto getTransferReadDto() {
        return transferReadDto;
    }

    public void setTransferReadDto(TransferReadDto transferReadDto) {
        this.transferReadDto = transferReadDto;
    }
}
