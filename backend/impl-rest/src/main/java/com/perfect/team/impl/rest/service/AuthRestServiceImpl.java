package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.api.rest.response.SignInResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.auth.service.AuthService;
import com.perfect.team.business.entity.User;
import com.perfect.team.impl.rest.service.base.RestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AuthRestServiceImpl extends RestServiceImpl implements AuthRestService {

    @Inject
    private AuthService authService;

    @Override
    public UserResponse signUp(UserRequest userRequest) {
        User user = modelMapper.map(userRequest.getUserDto(), User.class);
        user = authService.signUp(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserDto(modelMapper.map(user, UserDto.class));
        return userResponse;
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        AuthUser authUser = authService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        SignInResponse signInResponse = modelMapper.map(authUser, SignInResponse.class);
        signInResponse.setUserDto(modelMapper.map(authUser.getUser(), UserDto.class));
        return signInResponse;
    }

    @Override
    public SignInResponse signInWithFacebook(TokenRequest tokenRequest) {
        AuthUser authUser = authService.signInWithFacebook(tokenRequest.getToken());
        SignInResponse signInResponse = modelMapper.map(authUser, SignInResponse.class);
        signInResponse.setUserDto(modelMapper.map(authUser.getUser(), UserDto.class));
        return signInResponse;
    }
}
