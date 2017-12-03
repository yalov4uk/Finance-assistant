package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.api.rest.request.entity.UserRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public interface UserController extends CrudController<UserRequest> {
}
