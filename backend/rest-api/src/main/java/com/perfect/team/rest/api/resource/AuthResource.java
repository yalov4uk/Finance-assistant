package com.perfect.team.rest.api.resource;

import com.perfect.team.rest.api.request.SignInRq;
import com.perfect.team.rest.api.request.SignUpRq;
import com.perfect.team.rest.api.response.AuthRs;
import com.perfect.team.rest.api.response.UserRs;
import com.perfect.team.rest.api.validation.SignIn;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
      @ApiResponse(code = 200, message = "", response = UserRs.class)
  )
  Response signUp(@NotNull @Valid SignUpRq request, @Context HttpHeaders headers);

  @POST
  @Path("signIn")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = AuthRs.class)
  )
  Response signIn(@SignIn @NotNull @Valid SignInRq request,
      @Pattern(regexp = "facebook") @QueryParam("method") String method,
      @Context HttpHeaders headers);
}
