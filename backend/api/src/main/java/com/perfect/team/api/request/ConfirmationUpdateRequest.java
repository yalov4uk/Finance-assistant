package com.perfect.team.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.dto.ConfirmationUpdateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ConfirmationUpdateRequest {

  @NotNull
  @Valid
  @JsonProperty("confirmation")
  private ConfirmationUpdateDto confirmationDto;

  public ConfirmationUpdateDto getConfirmationDto() {
    return confirmationDto;
  }

  public void setConfirmationDto(ConfirmationUpdateDto confirmationDto) {
    this.confirmationDto = confirmationDto;
  }
}
