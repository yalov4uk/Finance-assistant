package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    ResponseEntity signUp(SignUpRequest signUpRequest);

    ResponseEntity signIn(SignInRequest signInRequest);

    ResponseEntity signInWithFacebook(TokenRequest tokenRequest);
}
