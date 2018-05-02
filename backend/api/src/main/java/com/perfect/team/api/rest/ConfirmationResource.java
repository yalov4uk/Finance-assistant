package com.perfect.team.api.rest;

import com.perfect.team.api.request.ConfirmationCreateRequest;
import com.perfect.team.api.request.ConfirmationUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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

  @PUT
  @ApiResponses(
      @ApiResponse(code = 303, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response update(@NotNull @Valid ConfirmationUpdateRequest request);
}
