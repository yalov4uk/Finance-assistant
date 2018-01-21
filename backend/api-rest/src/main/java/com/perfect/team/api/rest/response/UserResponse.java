package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.UserReadDto;

public class UserResponse {

    @JsonProperty(value = "user")
    private UserReadDto userReadDto;

    public UserReadDto getUserReadDto() {
        return userReadDto;
    }

    public void setUserReadDto(UserReadDto userReadDto) {
        this.userReadDto = userReadDto;
    }
}
