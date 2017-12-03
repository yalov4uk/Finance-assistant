package com.perfect.team.api.rest.controller.base;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface CrudController<Request> {

    @POST
    Response create(Request request);

    @GET
    @Path("/{id}")
    Response read(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    Response update(@PathParam("id") Long id, Request request);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") Long id);

    @GET
    Response readAll();
}
