package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.api.rest.response.SignInResponse;
import com.perfect.team.api.rest.response.UserResponse;

public interface AuthRestService {

    UserResponse signUp(UserRequest userRequest);

    SignInResponse signIn(SignInRequest signInRequest);

    SignInResponse signInWithFacebook(TokenRequest tokenRequest);
}
