package com.perfect.team.api.rest;

import com.perfect.team.api.request.UserReadRequest;
import com.perfect.team.api.request.UserUpdateRequest;
import com.perfect.team.api.response.UserResponse;
import com.perfect.team.api.response.UsersResponse;
import com.perfect.team.api.validation.constraint.AtLeastOneNotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(authorizations = {@Authorization("Auth-token")})
public interface UserResource {

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = UsersResponse.class)
  )
  Response read(@AtLeastOneNotNull(fieldNames = {"id"}) @Valid @BeanParam UserReadRequest request);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = UserResponse.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid UserUpdateRequest request);
}
