package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.api.rest.response.SignInResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.auth.service.AuthService;
import com.perfect.team.business.entity.User;
import com.perfect.team.impl.rest.mapper.SignInMapper;
import com.perfect.team.impl.rest.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AuthRestServiceImpl implements AuthRestService {

    @Inject
    private AuthService authService;

    @Inject
    private UserMapper userMapper;

    @Inject
    private SignInMapper signInMapper;

    @Override
    public UserResponse signUp(UserRequest userRequest) {
        User user = userMapper.mapRequest(userRequest);
        user = authService.signUp(user);
        return userMapper.mapEntity(user);
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        AuthUser authUser = authService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        return signInMapper.mapEntity(authUser);
    }

    @Override
    public SignInResponse signInWithFacebook(TokenRequest tokenRequest) {
        AuthUser authUser = authService.signInWithFacebook(tokenRequest.getToken());
        return signInMapper.mapEntity(authUser);
    }
}
