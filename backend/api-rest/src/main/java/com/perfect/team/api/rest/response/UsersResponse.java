package com.perfect.team.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.UserReadDto;

import java.util.List;

public class UsersResponse {

    @JsonProperty(value = "users")
    private List<UserReadDto> userReadDtos;

    public List<UserReadDto> getUserReadDtos() {
        return userReadDtos;
    }

    public void setUserReadDtos(List<UserReadDto> userReadDtos) {
        this.userReadDtos = userReadDtos;
    }
}
