package com.perfect.team.service.response;


import com.perfect.team.service.dto.UserReadDto;
import com.perfect.team.service.response.base.BaseResponse;
import java.util.List;

public class UsersResponse extends BaseResponse {

  private List<UserReadDto> userReadDtos;

  public List<UserReadDto> getUserReadDtos() {
    return userReadDtos;
  }

  public void setUserReadDtos(List<UserReadDto> userReadDtos) {
    this.userReadDtos = userReadDtos;
  }

  @Override
  public String toString() {
    return "UsersResponse{" +
        "userReadDtos=" + userReadDtos +
        "} " + super.toString();
  }
}
