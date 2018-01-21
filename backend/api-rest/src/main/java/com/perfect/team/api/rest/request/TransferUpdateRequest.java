package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.TransferUpdateDto;

public class TransferUpdateRequest {

    @JsonProperty(value = "transfer")
    private TransferUpdateDto transferDto;

    public TransferUpdateDto getTransferDto() {
        return transferDto;
    }

    public void setTransferDto(TransferUpdateDto transferDto) {
        this.transferDto = transferDto;
    }
}
