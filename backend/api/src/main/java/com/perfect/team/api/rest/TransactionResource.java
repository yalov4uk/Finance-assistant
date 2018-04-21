package com.perfect.team.api.rest;

import com.perfect.team.api.request.TransactionCreateRequest;
import com.perfect.team.api.request.TransactionReadRequest;
import com.perfect.team.api.request.TransactionUpdateRequest;
import com.perfect.team.api.response.TransactionResponse;
import com.perfect.team.api.response.TransactionsResponse;
import com.perfect.team.api.validation.constraint.AtLeastOneNotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(authorizations = {@Authorization("Auth-token")})
public interface TransactionResource {

  @POST
  @ApiResponses(
      @ApiResponse(code = 201, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response create(@NotNull @Valid TransactionCreateRequest request);

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransactionsResponse.class)
  )
  Response read(@AtLeastOneNotNull(fieldNames = {"id", "categoryId", "accountId",
      "userId"}) @Valid @BeanParam TransactionReadRequest request);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = TransactionResponse.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid TransactionUpdateRequest request);

  @DELETE
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 204, message = "")
  )
  Response delete(@PathParam("id") Long id);
}
