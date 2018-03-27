package com.perfect.team.rest.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.TransferReadDto;

public class TransferRs {

  @JsonProperty(value = "transfer")
  private TransferReadDto transferReadDto;

  public TransferReadDto getTransferReadDto() {
    return transferReadDto;
  }

  public void setTransferReadDto(TransferReadDto transferReadDto) {
    this.transferReadDto = transferReadDto;
  }
}
