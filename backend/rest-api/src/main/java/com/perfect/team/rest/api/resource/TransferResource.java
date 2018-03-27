package com.perfect.team.rest.api.resource;

import com.perfect.team.rest.api.request.TransferCreateRq;
import com.perfect.team.rest.api.request.TransferUpdateRq;
import com.perfect.team.rest.api.response.TransferRs;
import com.perfect.team.rest.api.response.TransfersRs;
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

@Path("transfers")
@Produces("application/json")
@Consumes("application/json")
@Api
public interface TransferResource {

  @POST
  @ApiResponses(
      @ApiResponse(code = 201, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response create(@NotNull @Valid TransferCreateRq request, @Context HttpHeaders headers);

  @GET
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransferRs.class)
  )
  Response read(@PathParam("id") Long id, @Context HttpHeaders headers);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransferRs.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid TransferUpdateRq request,
      @Context HttpHeaders headers);

  @DELETE
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 204, message = "")
  )
  Response delete(@PathParam("id") Long id, @Context HttpHeaders headers);

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransfersRs.class)
  )
  Response readAll(@Context HttpHeaders headers);
}
