package com.perfect.team.legacy.api;

import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import com.perfect.team.legacy.api.request.CategoryCreateRequest;
import com.perfect.team.legacy.api.request.CategoryReadRequest;
import com.perfect.team.legacy.api.request.CategoryUpdateRequest;
import com.perfect.team.legacy.api.response.CategoriesResponse;
import com.perfect.team.legacy.api.response.CategoryResponse;
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

@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(authorizations = {@Authorization("Authorization")})
public interface CategoryResource {

  @POST
  @ApiResponses(
      @ApiResponse(code = 201, message = "", responseHeaders = {
          @ResponseHeader(name = "location", response = URI.class)
      })
  )
  Response create(@NotNull @Valid CategoryCreateRequest request);

  @GET
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = CategoriesResponse.class)
  )
  Response read(@AtLeastOneNotNull(fieldNames = {"id",
      "userId"}) @Valid @BeanParam CategoryReadRequest request);

  @PUT
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 200, message = "", response = CategoryResponse.class)
  )
  Response update(@PathParam("id") Long id, @NotNull @Valid CategoryUpdateRequest request);

  @DELETE
  @Path("{id}")
  @ApiResponses(
      @ApiResponse(code = 204, message = "")
  )
  Response delete(@PathParam("id") Long id);
}
