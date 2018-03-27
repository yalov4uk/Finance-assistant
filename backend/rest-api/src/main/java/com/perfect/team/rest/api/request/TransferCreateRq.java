package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.TransferCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferCreateRq {

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
