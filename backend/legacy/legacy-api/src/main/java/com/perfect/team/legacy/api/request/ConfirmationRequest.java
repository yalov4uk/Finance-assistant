package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.ConfirmationDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ConfirmationRequest {

  @NotNull
  @Valid
  @JsonProperty("confirmation")
  private ConfirmationDto confirmationDto;

  public ConfirmationDto getConfirmationDto() {
    return confirmationDto;
  }

  public void setConfirmationDto(ConfirmationDto confirmationDto) {
    this.confirmationDto = confirmationDto;
  }
}
