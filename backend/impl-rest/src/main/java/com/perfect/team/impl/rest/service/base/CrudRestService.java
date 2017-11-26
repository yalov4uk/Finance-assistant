package com.perfect.team.impl.rest.service.base;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthCrudRestService<Request, Response, ListResponse> extends RestService {

    Response create(Request request, UserDetails userDetails);

    Response read(Long id, UserDetails userDetails);

    Response update(Request request, UserDetails userDetails);

    void delete(Long id, UserDetails userDetails);

    ListResponse readAll(UserDetails userDetails);
}
