package com.perfect.team.common.api.rest;

import com.perfect.team.common.api.request.ConfirmationCreateRequest;
import com.perfect.team.common.api.request.ConfirmationRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("confirmations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api
public interface ConfirmationResource {

  @POST
  @ApiResponses(
      @ApiResponse(code = 204, message = "")
  )
  Response create(@NotNull @Valid ConfirmationCreateRequest request);

  @POST
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 303, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response confirm(@PathParam("id") Long id, @NotNull @Valid ConfirmationRequest request);
}
