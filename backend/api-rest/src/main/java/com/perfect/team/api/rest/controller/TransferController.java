package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.TransferCreateRequest;
import com.perfect.team.api.rest.request.TransferUpdateRequest;
import com.perfect.team.api.rest.response.TransferResponse;
import com.perfect.team.api.rest.response.TransfersResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/transfers")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface TransferController {

    @POST
    @ApiResponses(
            @ApiResponse(code = 201, message = "", responseHeaders = {
                    @ResponseHeader(name = "location", response = URI.class)
            })
    )
    Response create(@NotNull @Valid TransferCreateRequest request);

    @GET
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransferResponse.class)
    )
    Response read(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransferResponse.class)
    )
    Response update(@PathParam("id") Long id, @NotNull @Valid TransferUpdateRequest request);

    @DELETE
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 204, message = "")
    )
    Response delete(@PathParam("id") Long id);

    @GET
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransfersResponse.class)
    )
    Response readAll();
}
