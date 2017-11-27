package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.UserDto;
import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.auth.service.AuthService;
import com.perfect.team.business.entity.User;
import com.perfect.team.impl.rest.service.base.RestServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class AuthRestServiceImpl extends RestServiceImpl implements AuthRestService {

    @Inject
    private AuthService authService;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        User user = modelMapper.map(signUpRequest.getSignUpUserDto(), User.class);
        AuthUser authUser = authService.signUp(user, signUpRequest.getSignUpUserDto().getConfirmPassword());
        return mapEntityToResponse(authUser);
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        AuthUser authUser = authService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        return mapEntityToResponse(authUser);
    }

    @Override
    public AuthResponse signInWithFacebook(TokenRequest tokenRequest) {
        AuthUser authUser = authService.signInWithFacebook(tokenRequest.getToken());
        return mapEntityToResponse(authUser);
    }

    private AuthResponse mapEntityToResponse(AuthUser authUser) {
        AuthResponse authResponse = modelMapper.map(authUser, AuthResponse.class);
        authResponse.setUserDto(modelMapper.map(authUser.getUser(), UserDto.class));
        return authResponse;
    }
}
