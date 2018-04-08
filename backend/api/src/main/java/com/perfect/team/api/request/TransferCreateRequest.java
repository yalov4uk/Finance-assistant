package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.TransferCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferCreateRequest {

  @NotNull
  @Valid
  @JsonProperty(value = "transfer")
  private TransferCreateDto transferDto;

  public TransferCreateDto getTransferDto() {
    return transferDto;
  }

  public void setTransferDto(TransferCreateDto transferDto) {
    this.transferDto = transferDto;
  }
}
