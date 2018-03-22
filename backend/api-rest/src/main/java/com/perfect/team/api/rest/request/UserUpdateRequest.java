package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.UserUpdateDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserUpdateRequest {

    @NotNull
    @Valid
    @JsonProperty(value = "user")
    private UserUpdateDto userUpdateDto;

    public UserUpdateDto getUserUpdateDto() {
        return userUpdateDto;
    }

    public void setUserUpdateDto(UserUpdateDto userUpdateDto) {
        this.userUpdateDto = userUpdateDto;
    }
}
