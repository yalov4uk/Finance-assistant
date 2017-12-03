package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.AuthController;
import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import com.perfect.team.impl.rest.service.AuthRestService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Controller
public class AuthControllerImpl implements AuthController {

    @Inject
    private AuthRestService authRestService;

    @Override
    public Response signUp(SignUpRequest request) {
        AuthResponse authResponse = authRestService.signUp(request);
        return Response.ok(authResponse).build();
    }

    @Override
    public Response signIn(SignInRequest request) {
        AuthResponse authResponse = authRestService.signIn(request);
        return Response.ok(authResponse).build();
    }

    @Override
    public Response signInWithFacebook(TokenRequest request) {
        AuthResponse authResponse = authRestService.signInWithFacebook(request);
        return Response.ok(authResponse).build();
    }
}
