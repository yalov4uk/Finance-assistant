package com.perfect.team.api.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfect.team.api.rest.dto.SignUpDto;

public class SignUpRequest {

    @JsonProperty(value = "user")
    private SignUpDto signUpDto;

    public SignUpDto getSignUpDto() {
        return signUpDto;
    }

    public void setSignUpDto(SignUpDto signUpDto) {
        this.signUpDto = signUpDto;
    }
}
