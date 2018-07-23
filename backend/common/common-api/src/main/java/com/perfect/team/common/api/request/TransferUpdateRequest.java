package com.perfect.team.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.common.api.dto.TransferUpdateDto;
import com.perfect.team.common.api.validation.constraint.NotEqualFields;
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
