package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.TransferReadDto;
import java.util.List;

public class TransfersRs {

  @JsonProperty(value = "transfers")
  private List<TransferReadDto> transferReadDtos;

  public List<TransferReadDto> getTransferReadDtos() {
    return transferReadDtos;
  }

  public void setTransferReadDtos(List<TransferReadDto> transferReadDtos) {
    this.transferReadDtos = transferReadDtos;
  }
}
