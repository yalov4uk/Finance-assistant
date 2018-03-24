package com.perfect.team.service.response;

import com.perfect.team.service.dto.UserReadDto;
import com.perfect.team.service.response.base.BaseResponse;

public class UserResponse extends BaseResponse {
    private UserReadDto userReadDto;

    public UserReadDto getUserReadDto() {
        return userReadDto;
    }

    public void setUserReadDto(UserReadDto userReadDto) {
        this.userReadDto = userReadDto;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userReadDto=" + userReadDto +
                "} " + super.toString();
    }
}
