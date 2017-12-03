package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.request.TokenRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface AuthController {

    @POST
    @Path("/signup")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = AuthResponse.class)
    )
    Response signUp(SignUpRequest request);

    @POST
    @Path("/signin")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = AuthResponse.class)
    )
    Response signIn(SignInRequest request);

    @POST
    @Path("/signin/facebook")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = AuthResponse.class)
    )
    Response signInWithFacebook(TokenRequest request);
}
