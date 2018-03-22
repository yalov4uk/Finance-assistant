package com.perfect.team.service.response;


import com.perfect.team.service.dto.UserReadDto;
import com.perfect.team.service.response.base.BaseResponse;

public class AuthResponse extends BaseResponse {
    private UserReadDto userReadDto;
    private String token;

    public UserReadDto getUserReadDto() {
        return userReadDto;
    }

    public void setUserReadDto(UserReadDto userReadDto) {
        this.userReadDto = userReadDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
