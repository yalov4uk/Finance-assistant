package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.UserReadDto;
import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.auth.service.AuthService;
import com.perfect.team.business.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class AuthRestServiceImpl implements AuthRestService {

    @Inject
    private ModelMapper modelMapper;

    @Inject
    private AuthService authService;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        User user = modelMapper.map(signUpRequest.getSignUpDto(), User.class);
        AuthUser authUser = authService.signUp(user, signUpRequest.getSignUpDto().getPasswordConfirmation());
        return mapAuthUserToAuthResponse(authUser);
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        AuthUser authUser = authService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        return mapAuthUserToAuthResponse(authUser);
    }

    @Override
    public AuthResponse signInWithFacebook(TokenRequest tokenRequest) {
        AuthUser authUser = authService.signInWithFacebook(tokenRequest.getToken());
        return mapAuthUserToAuthResponse(authUser);
    }

    private AuthResponse mapAuthUserToAuthResponse(AuthUser authUser) {
        AuthResponse authResponse = modelMapper.map(authUser, AuthResponse.class);
        authResponse.setUserReadDto(modelMapper.map(authUser.getUser(), UserReadDto.class));
        return authResponse;
    }
}
