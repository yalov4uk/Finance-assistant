package com.perfect.team.legacy.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.TransferReadDto;

public class TransferResponse {

  @JsonProperty(value = "transfer")
  private TransferReadDto transferDto;

  public TransferReadDto getTransferDto() {
    return transferDto;
  }

  public void setTransferDto(TransferReadDto transferDto) {
    this.transferDto = transferDto;
  }
}
