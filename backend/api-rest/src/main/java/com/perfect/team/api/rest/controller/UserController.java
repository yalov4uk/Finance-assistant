package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.UserUpdateRequest;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.api.rest.response.UsersResponse;
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
import javax.ws.rs.core.Response;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface UserController {

    @GET
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = UserResponse.class)
    )
    Response read(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = UserResponse.class)
    )
    Response update(@PathParam("id") Long id, @NotNull @Valid UserUpdateRequest request);

    @DELETE
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 204, message = "")
    )
    Response delete(@PathParam("id") Long id);

    @GET
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = UsersResponse.class)
    )
    Response readAll();
}
