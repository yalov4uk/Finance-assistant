package com.perfect.team.rest.api.resource;

import com.perfect.team.rest.api.request.TransactionCreateRq;
import com.perfect.team.rest.api.request.TransactionUpdateRq;
import com.perfect.team.rest.api.response.TransactionRs;
import com.perfect.team.rest.api.response.TransactionsRs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("transactions")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface TransactionResource {

  @POST
  @ApiResponses(
      @ApiResponse(code = 201, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response create(@NotNull @Valid TransactionCreateRq request, @Context HttpHeaders headers);

  @GET
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransactionRs.class)
  )
  Response read(@PathParam("id") Long id, @Context HttpHeaders headers);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransactionRs.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid TransactionUpdateRq request,
      @Context HttpHeaders headers);

  @DELETE
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 204, message = "")
  )
  Response delete(@PathParam("id") Long id, @Context HttpHeaders headers);

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransactionsRs.class)
  )
  Response readAll(@Context HttpHeaders headers);
}
