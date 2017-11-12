package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.request.UserRequest;
import org.springframework.http.HttpEntity;

public interface AuthController {

    HttpEntity signUp(UserRequest userRequest);

    HttpEntity signIn(SignInRequest signInRequest);

    HttpEntity signInWithFacebook(TokenRequest tokenRequest);
}
