package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateRequest {

    @JsonProperty(value = "user")
    private UserUpdateRequest userRequest;

    public UserUpdateRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserUpdateRequest userRequest) {
        this.userRequest = userRequest;
    }
}
