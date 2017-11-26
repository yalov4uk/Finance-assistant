package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.entity.UserDto;

public class UserRequest {

    @JsonProperty(value = "user")
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
