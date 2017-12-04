package com.perfect.team.impl.rest.provider.exception;

import com.perfect.team.business.exception.ValidationException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
