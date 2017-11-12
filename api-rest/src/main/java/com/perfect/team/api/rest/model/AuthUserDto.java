package com.perfect.team.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.model.entity.UserDto;

public class AuthUserDto {

    @JsonProperty(value = "user")
    private UserDto userDto;

    @JsonProperty(value = "token")
    private String token;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
