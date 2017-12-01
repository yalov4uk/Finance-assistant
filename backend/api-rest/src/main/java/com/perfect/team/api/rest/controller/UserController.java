package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.api.rest.response.entity.UserResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public interface UserController extends CrudController<UserRequest, UserResponse> {

    @GET
    Response readAll();
}
