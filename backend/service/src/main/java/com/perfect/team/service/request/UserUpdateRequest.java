package com.perfect.team.service.request;

import com.perfect.team.service.dto.UserUpdateDto;
import com.perfect.team.service.request.base.AuthRequest;

public class UserUpdateRequest extends AuthRequest {

  private UserUpdateDto userUpdateDto;

  public UserUpdateDto getUserUpdateDto() {
    return userUpdateDto;
  }

  public void setUserUpdateDto(UserUpdateDto userUpdateDto) {
    this.userUpdateDto = userUpdateDto;
  }

  @Override
  public String toString() {
    return "UserUpdateRequest{" +
        "userUpdateDto=" + userUpdateDto +
        "} " + super.toString();
  }
}