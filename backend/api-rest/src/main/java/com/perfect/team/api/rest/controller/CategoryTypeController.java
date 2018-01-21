package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.response.CategoryTypeResponse;
import com.perfect.team.api.rest.response.CategoryTypesResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/categoryTypes")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface CategoryTypeController {

    @GET
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = CategoryTypeResponse.class)
    )
    Response read(@PathParam("id") Long id);

    @DELETE
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 204, message = "")
    )
    Response delete(@PathParam("id") Long id);

    @GET
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = CategoryTypesResponse.class)
    )
    Response readAll();
}
