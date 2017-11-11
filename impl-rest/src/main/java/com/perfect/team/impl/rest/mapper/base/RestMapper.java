package com.perfect.team.impl.rest.mapper.base;

public interface RestMapper<Request, Entity, Response> {

    Entity mapRequest(Request request);

    Response mapEntity(Entity entity);
}
