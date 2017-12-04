package com.perfect.team.impl.rest.provider.exception;

import com.perfect.team.business.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
