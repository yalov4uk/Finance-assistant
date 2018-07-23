package com.perfect.team.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.TransferReadDto;
import java.util.List;

public class TransfersResponse {

  @JsonProperty(value = "transfers")
  private List<TransferReadDto> transferDtos;

  public List<TransferReadDto> getTransferDtos() {
    return transferDtos;
  }

  public void setTransferDtos(List<TransferReadDto> transferDtos) {
    this.transferDtos = transferDtos;
  }
}
