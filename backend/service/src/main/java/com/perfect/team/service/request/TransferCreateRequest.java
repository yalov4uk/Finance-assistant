package com.perfect.team.service.request;


import com.perfect.team.service.dto.TransferCreateDto;
import com.perfect.team.service.request.base.AuthRequest;

public class TransferCreateRequest extends AuthRequest {

  private TransferCreateDto transferDto;

  public TransferCreateDto getTransferDto() {
    return transferDto;
  }

  public void setTransferDto(TransferCreateDto transferDto) {
    this.transferDto = transferDto;
  }

  @Override
  public String toString() {
    return "TransferCreateRequest{" +
        "transferDto=" + transferDto +
        "} " + super.toString();
  }
}
