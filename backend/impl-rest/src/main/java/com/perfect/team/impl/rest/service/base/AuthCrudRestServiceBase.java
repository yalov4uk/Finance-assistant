package com.perfect.team.impl.rest.service.base;

import com.perfect.team.business.service.base.AuthCrudService;

import java.io.Serializable;
import java.util.List;

public abstract class AuthCrudRestServiceBase<Request, Entity extends Serializable, Response, ListResponse>
        extends CrudRestServiceBase<Request, Entity, Response, ListResponse>
        implements AuthCrudRestService<Request, Response, ListResponse> {

    protected abstract AuthCrudService<Entity> getCrudService();

    @Override
    public ListResponse readAllByUserId(Long userId) {
        List<Entity> entities = getCrudService().readAllByUserId(userId);
        return mapEntitiesToListResponse(entities);
    }
}
