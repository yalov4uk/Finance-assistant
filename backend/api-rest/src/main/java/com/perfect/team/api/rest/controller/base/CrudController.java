package com.perfect.team.api.rest.controller.base;

import org.springframework.http.ResponseEntity;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface CrudController<Request, Response> {

    @POST
    ResponseEntity<Response> create(@BeanParam Request request);

    @GET @Path("/{id}")
    ResponseEntity<Response> read(@PathParam("id") Long id);

    @PUT @Path("/{id}")
    ResponseEntity<Response> update(@PathParam("id") Long id, Request bean);

    @DELETE @Path("/{id}")
    ResponseEntity delete(@PathParam("id") Long id);
}
