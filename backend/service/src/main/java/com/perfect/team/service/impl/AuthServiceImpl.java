package com.perfect.team.service.impl;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.service.api.AuthService;
import com.perfect.team.service.request.SignInRequest;
import com.perfect.team.service.request.SignUpRequest;
import com.perfect.team.service.response.AuthResponse;
import com.perfect.team.service.response.UserResponse;
import org.springframework.stereotype.Service;

@Service("AuthServiceImpl")
public class AuthServiceImpl implements AuthService {
    @Override
    public UserResponse signUp(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse signIn(SignInRequest request) {
        return null;
    }
}
