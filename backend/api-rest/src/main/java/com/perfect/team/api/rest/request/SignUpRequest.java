package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.SignUpUserDto;

public class SignUpRequest {

    @JsonProperty(value = "user")
    private SignUpUserDto signUpUserDto;

    public SignUpUserDto getSignUpUserDto() {
        return signUpUserDto;
    }

    public void setSignUpUserDto(SignUpUserDto signUpUserDto) {
        this.signUpUserDto = signUpUserDto;
    }
}
