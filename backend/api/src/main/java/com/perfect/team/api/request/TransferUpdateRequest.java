package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.TransferUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferUpdateRequest {

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
