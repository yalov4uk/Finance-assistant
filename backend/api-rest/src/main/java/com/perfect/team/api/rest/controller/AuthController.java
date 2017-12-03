package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
public interface AuthController {

    @POST
    @Path("/signup")
    Response signUp(SignUpRequest request);

    @POST
    @Path("/signin")
    Response signIn(SignInRequest request);

    @POST
    @Path("/signin/facebook")
    Response signInWithFacebook(TokenRequest request);
}
