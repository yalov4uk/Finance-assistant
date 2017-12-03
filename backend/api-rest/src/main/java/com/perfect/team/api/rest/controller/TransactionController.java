package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.request.entity.TransactionRequest;
import com.perfect.team.api.rest.response.entity.TransactionResponse;
import com.perfect.team.api.rest.response.entity.TransactionsResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

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

@Path("/transactions")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface TransactionController {

    @POST
    @ApiResponses(
            @ApiResponse(code = 201, message = "", responseHeaders = {
                    @ResponseHeader(name = "location", response = URI.class)
            })
    )
    Response create(TransactionRequest request);

    @GET
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransactionResponse.class)
    )
    Response read(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransactionResponse.class)
    )
    Response update(@PathParam("id") Long id, TransactionRequest request);

    @DELETE
    @Path("/{id}")
    @ApiResponses(
            @ApiResponse(code = 204, message = "")
    )
    Response delete(@PathParam("id") Long id);

    @GET
    @ApiResponses(
            @ApiResponse(code = 200, message = "", response = TransactionsResponse.class)
    )
    Response readAll();
}
