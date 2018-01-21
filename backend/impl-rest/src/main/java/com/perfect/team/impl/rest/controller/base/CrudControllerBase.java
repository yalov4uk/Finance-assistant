package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.impl.rest.service.base.CrudRestService;

import javax.ws.rs.core.Response;

public abstract class CrudControllerBase<Request> {

    protected abstract CrudRestService getService();

    public Response create(Request request) {
        return Response.created(getService().create(request)).build();
    }

    public Response read(Long id) {
        return Response.ok(getService().read(id)).build();
    }

    public Response update(Long id, Request request) {
        return Response.ok(getService().update(id, request)).build();
    }

    public Response delete(Long id) {
        getService().delete(id);
        return Response.noContent().build();
    }

    public Response readAll() {
        return Response.ok(getService().readAll()).build();
    }
}
