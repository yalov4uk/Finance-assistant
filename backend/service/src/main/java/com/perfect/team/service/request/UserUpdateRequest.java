package com.perfect.team.service.request;

import com.perfect.team.service.dto.UserUpdateDto;
import com.perfect.team.service.request.base.BaseRequest;

public class UserUpdateRequest extends BaseRequest {
    private UserUpdateDto userUpdateDto;

    public UserUpdateDto getUserUpdateDto() {
        return userUpdateDto;
    }

    public void setUserUpdateDto(UserUpdateDto userUpdateDto) {
        this.userUpdateDto = userUpdateDto;
    }
}
