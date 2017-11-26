package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.model.entity.TransferDto;
import com.perfect.team.api.rest.model.entity.UserDto;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public class TransfersResponse {

    @JsonProperty(value = "transfers")
    private List<TransferDto> transferDtos;

    public List<TransferDto> getTransferDtos() {
        return transferDtos;
    }

    public void setTransferDtos(List<TransferDto> transferDtos) {
        this.transferDtos = transferDtos;
    }

}