package com.perfect.team.service.request;


import com.perfect.team.service.dto.SignUpDto;
import com.perfect.team.service.request.base.BaseRequest;

public class SignUpRequest extends BaseRequest {
    private SignUpDto signUpDto;

    public SignUpDto getSignUpDto() {
        return signUpDto;
    }

    public void setSignUpDto(SignUpDto signUpDto) {
        this.signUpDto = signUpDto;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "signUpDto=" + signUpDto +
                "} " + super.toString();
    }
}
