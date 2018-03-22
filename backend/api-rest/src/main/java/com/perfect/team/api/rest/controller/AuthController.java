package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.request.SignUpRequest;
import com.perfect.team.api.rest.response.AuthResponse;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.api.rest.validation.SignIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface AuthController {

    @POST
    @Path("/signUp")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = UserResponse.class)
    )
    Response signUp(@NotNull @Valid SignUpRequest request);

    @POST
    @Path("/signIn")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = AuthResponse.class)
    )
    Response signIn(@SignIn @NotNull @Valid SignInRequest request,
                    @Pattern(regexp = "facebook") @QueryParam("method") String method);
}
