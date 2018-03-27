package com.perfect.team.rest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.rest.api.dto.TransferUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferUpdateRq {

  @NotNull
  @Valid
  @JsonProperty(value = "transfer")
  private TransferUpdateDto transferDto;

  public TransferUpdateDto getTransferDto() {
    return transferDto;
  }

  public void setTransferDto(TransferUpdateDto transferDto) {
    this.transferDto = transferDto;
  }
}
