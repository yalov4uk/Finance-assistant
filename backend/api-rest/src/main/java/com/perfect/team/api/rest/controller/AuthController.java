package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest);

    ResponseEntity<AuthResponse>  signIn(SignInRequest signInRequest);

    ResponseEntity<AuthResponse>  signInWithFacebook(TokenRequest tokenRequest);
}
