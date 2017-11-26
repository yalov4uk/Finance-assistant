package com.perfect.team.impl.rest.service.base;

import com.perfect.team.business.service.base.CrudService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public abstract class AuthCrudRestServiceImpl<Request, Entity, Response, ListResponse> extends RestServiceImpl
        implements AuthCrudRestService<Request, Response, ListResponse> {

    protected abstract CrudService<Entity> getCrudService();

    protected abstract Entity mapRequestToEntity(Request request);

    protected abstract Response mapEntityToResponse(Entity entity);

    protected abstract ListResponse mapEntitiesToListResponse(List<Entity> entities);

    @Override
    public Response create(Request request, UserDetails userDetails) {
        Entity entity = mapRequestToEntity(request);
        entity = getCrudService().create(entity);
        return mapEntityToResponse(entity);
    }

    @Override
    public Response read(Long id, UserDetails userDetails) {
        Entity entity = getCrudService().read(id);
        return mapEntityToResponse(entity);
    }

    @Override
    public Response update(Request request, UserDetails userDetails) {
        Entity entity = mapRequestToEntity(request);
        entity = getCrudService().update(entity);
        return mapEntityToResponse(entity);
    }

    @Override
    public void delete(Long id, UserDetails userDetails) {
        getCrudService().delete(id);
    }

    @Override
    public ListResponse readAll(UserDetails userDetails) {
        List<Entity> entities = getCrudService().readAll();
        return mapEntitiesToListResponse(entities);
    }
}
