package com.perfect.team.service.request;

import com.perfect.team.service.dto.SignInDto;
import com.perfect.team.service.request.base.BaseRequest;

public class SignInRequest extends BaseRequest {
    private SignInDto signInDto;

    public SignInDto getSignInDto() {
        return signInDto;
    }

    public void setSignInDto(SignInDto signInDto) {
        this.signInDto = signInDto;
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
                "signInDto=" + signInDto +
                "} " + super.toString();
    }
}
