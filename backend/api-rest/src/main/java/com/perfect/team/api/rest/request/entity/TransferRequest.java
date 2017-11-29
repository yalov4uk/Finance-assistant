package com.perfect.team.api.rest.request.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.TransferDto;

/**
 * Created by Denis on 25.11.2017.
 */
public class TransferRequest {

    @JsonProperty(value = "transfer")
    private TransferDto transferDto;

    public TransferDto getTransferDto() {
        return transferDto;
    }

    public void setTransferDto(TransferDto transferDto) {
        this.transferDto = transferDto;
    }
}