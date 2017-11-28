package com.perfect.team.impl.rest.service.base;

import com.perfect.team.business.service.base.CrudService;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRestServiceBase<Request, Entity extends Serializable, Response, ListResponse>
        extends RestServiceBase
        implements CrudRestService<Request, Response, ListResponse> {

    protected abstract CrudService<Entity> getCrudService();

    protected abstract Entity mapRequestToEntity(Request request);

    protected abstract Response mapEntityToResponse(Entity entity);

    protected abstract ListResponse mapEntitiesToListResponse(List<Entity> entities);

    @Override
    public Response create(Request request) {
        Entity entity = mapRequestToEntity(request);
        entity = getCrudService().create(entity);
        return mapEntityToResponse(entity);
    }

    @Override
    public Response read(Long id) {
        Entity entity = getCrudService().read(id);
        return mapEntityToResponse(entity);
    }

    @Override
    public Response update(Long id, Request request) {
        Entity entity = mapRequestToEntity(request);
        entity = getCrudService().update(id, entity);
        return mapEntityToResponse(entity);
    }

    @Override
    public void delete(Long id) {
        getCrudService().delete(id);
    }

    @Override
    public ListResponse readAll() {
        List<Entity> entities = getCrudService().readAll();
        return mapEntitiesToListResponse(entities);
    }
}
