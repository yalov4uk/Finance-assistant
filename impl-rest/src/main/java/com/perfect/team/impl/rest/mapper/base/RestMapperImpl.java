package com.perfect.team.impl.rest.mapper.base;

import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public abstract class RestMapperImpl<Request, Entity, Response> implements RestMapper<Request, Entity, Response> {

    @Inject
    protected ModelMapper modelMapper;

    protected abstract Class<Entity> getEntityClass();

    protected abstract Class<Response> getResponseClass();

    @Override
    public Entity mapRequest(Request request) {
        return modelMapper.map(request, getEntityClass());
    }

    @Override
    public Response mapEntity(Entity entity) {
        return modelMapper.map(entity, getResponseClass());
    }
}
