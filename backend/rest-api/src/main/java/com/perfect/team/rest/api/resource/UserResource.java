package com.perfect.team.rest.api.resource;

import com.perfect.team.rest.api.request.UserUpdateRq;
import com.perfect.team.rest.api.response.UserRs;
import com.perfect.team.rest.api.response.UsersRs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("users")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface UserResource {

  @GET
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = UserRs.class)
  )
  Response read(@PathParam("id") Long id, @Context HttpHeaders headers);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = UserRs.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid UserUpdateRq request,
      @Context HttpHeaders headers);

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = UsersRs.class)
  )
  Response readAll(@Context HttpHeaders headers);
}
