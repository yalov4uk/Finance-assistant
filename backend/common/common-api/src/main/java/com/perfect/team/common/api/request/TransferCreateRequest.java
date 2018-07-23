package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.TransferCreateDto;
import com.perfect.team.common.api.validation.constraint.NotEqualFields;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferCreateRequest {

  @NotNull
  @NotEqualFields(fieldNames = {"fromAccountId", "toAccountId"})
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
