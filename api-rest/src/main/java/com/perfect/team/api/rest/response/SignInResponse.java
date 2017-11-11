package com.perfect.team.api.rest.response;

public class SignInResponse {

    private UserResponse userResponse;

    private String token;

    public SignInResponse() {
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
