package com.perfect.team.api.rest.controller.base;

import org.springframework.http.HttpEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthCrudController<Request> {

    HttpEntity create(Request request, UserDetails userDetails);

    HttpEntity read(Long id, UserDetails userDetails);

    HttpEntity update(Long id, Request bean, UserDetails userDetails);

    HttpEntity delete(Long id, UserDetails userDetails);

    HttpEntity readAll(UserDetails userDetails);
}
