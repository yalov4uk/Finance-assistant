package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransferCreateDto;

public class TransferCreateRequest {

    @JsonProperty(value = "transfer")
    private TransferCreateDto transferDto;

    public TransferCreateDto getTransferDto() {
        return transferDto;
    }

    public void setTransferDto(TransferCreateDto transferDto) {
        this.transferDto = transferDto;
    }
}
