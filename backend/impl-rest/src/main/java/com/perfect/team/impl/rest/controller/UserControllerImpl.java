package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.UserController;
import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.api.rest.response.entity.UserResponse;
import com.perfect.team.api.rest.response.entity.UsersResponse;
import com.perfect.team.impl.rest.controller.base.CrudControllerBase;
import com.perfect.team.impl.rest.service.UserRestService;
import com.perfect.team.impl.rest.service.base.CrudRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@RequestMapping(
        value = "api/v1/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserControllerImpl extends CrudControllerBase<UserRequest, UserResponse, UsersResponse>
        implements UserController {

    @Inject
    private UserRestService userRestService;

    @Override
    protected CrudRestService<UserRequest, UserResponse, UsersResponse> getCrudRestService() {
        return userRestService;
    }
}