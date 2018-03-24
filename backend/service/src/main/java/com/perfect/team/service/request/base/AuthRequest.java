package com.perfect.team.service.request.base;

public class AuthRequest extends BaseRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "token='" + token + '\'' +
                "} " + super.toString();
    }
}
