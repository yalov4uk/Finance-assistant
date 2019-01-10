package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.validation.constraint.NotEqualFields;
import com.perfect.team.legacy.api.dto.TransferCreateDto;
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
