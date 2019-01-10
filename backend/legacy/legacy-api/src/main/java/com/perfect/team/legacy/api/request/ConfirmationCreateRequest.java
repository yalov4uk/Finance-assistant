package com.perfect.team.legacy.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.legacy.api.dto.ConfirmationCreateDto;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ConfirmationCreateRequest {

  @NotNull
  @Valid
  @JsonProperty("confirmation")
  private ConfirmationCreateDto confirmationDto;

  public ConfirmationCreateDto getConfirmationDto() {
    return confirmationDto;
  }

  public void setConfirmationDto(ConfirmationCreateDto confirmationDto) {
    this.confirmationDto = confirmationDto;
  }
}
