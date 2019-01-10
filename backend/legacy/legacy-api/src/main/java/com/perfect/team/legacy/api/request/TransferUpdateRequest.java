package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.validation.constraint.NotEqualFields;
import com.perfect.team.legacy.api.dto.TransferUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TransferUpdateRequest {

  @NotNull
  @NotEqualFields(fieldNames = {"fromAccountId", "toAccountId"})
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
