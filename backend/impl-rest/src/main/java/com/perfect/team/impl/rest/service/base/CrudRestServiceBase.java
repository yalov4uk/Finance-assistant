package com.perfect.team.impl.rest.service.base;

import com.perfect.team.business.service.custom.base.CrudService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

public abstract class CrudRestServiceBase<Request, Entity extends Serializable, Response, ListResponse>
        implements CrudRestService<Request, Response, ListResponse> {

    @Inject
    protected ModelMapper modelMapper;

    protected abstract CrudService<Entity> getService();

    protected abstract Entity mapRequestToEntity(Request request);

    protected abstract Response mapEntityToResponse(Entity entity);

    protected abstract ListResponse mapEntitiesToListResponse(List<Entity> entities);

    protected abstract String getEntityPath();

    @Override
    public URI create(Request request) {
        Entity entity = mapRequestToEntity(request);
        Long entityId = getService().create(entity);
        return UriBuilder.fromPath(getEntityPath() + String.valueOf(entityId)).build();
    }

    @Override
    public Response read(Long id) {
        Entity entity = getService().read(id);
        return mapEntityToResponse(entity);
    }

    @Override
    public Response update(Long id, Request request) {
        Entity entity = mapRequestToEntity(request);
        entity = getService().update(id, entity);
        return mapEntityToResponse(entity);
    }

    @Override
    public void delete(Long id) {
        getService().delete(id);
    }

    @Override
    public ListResponse readAll() {
        List<Entity> entities = getService().readAll();
        return mapEntitiesToListResponse(entities);
    }
}
