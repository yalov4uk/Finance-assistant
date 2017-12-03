package com.perfect.team.impl.rest.controller.base;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.impl.rest.service.base.CrudRestService;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public abstract class CrudControllerBase<Request> implements CrudController<Request> {

    protected abstract CrudRestService getService();

    @Override
    public Response create(Request request, UriInfo uriInfo) {
        return Response.created(getService().create(request, uriInfo)).build();
    }

    @Override
    public Response read(Long id) {
        return Response.ok(getService().read(id)).build();
    }

    @Override
    public Response update(Long id, Request request) {
        return Response.ok(getService().update(id, request)).build();
    }

    @Override
    public Response delete(Long id) {
        getService().delete(id);
        return Response.noContent().build();
    }

    @Override
    public Response readAll() {
        return Response.ok(getService().readAll()).build();
    }
}
