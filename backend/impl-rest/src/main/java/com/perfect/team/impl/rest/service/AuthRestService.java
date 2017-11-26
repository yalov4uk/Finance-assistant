package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;

public interface AuthRestService {

    AuthResponse signUp(SignUpRequest signUpRequest);

    AuthResponse signIn(SignInRequest signInRequest);

    AuthResponse signInWithFacebook(TokenRequest tokenRequest);
}
