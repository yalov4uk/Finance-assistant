package com.perfect.team.api.rest;

import com.perfect.team.api.request.SignInRequest;
import com.perfect.team.api.request.SignUpRequest;
import com.perfect.team.api.response.SignInResponse;
import com.perfect.team.api.response.SignUpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api
public interface AuthResource {

  @POST
  @Path("signUp")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = SignUpResponse.class)
  )
  Response signUp(@NotNull @Valid SignUpRequest request);

  @POST
  @Path("signIn")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = SignInResponse.class)
  )
  Response signIn(@NotNull @Valid SignInRequest request);

  @GET
  @Path("signInWith")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = SignInResponse.class)
  )
  Response signInWith(@NotNull @QueryParam("token") String token,
      @Pattern(regexp = "facebook") @QueryParam("method") String method);
}
