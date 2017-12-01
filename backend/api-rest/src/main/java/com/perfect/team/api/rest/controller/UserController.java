package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.api.rest.response.entity.UserResponse;
import com.perfect.team.api.rest.response.entity.UsersResponse;
import org.springframework.http.ResponseEntity;

public interface UserController extends CrudController<UserRequest, UserResponse> {

    ResponseEntity<UsersResponse> readAll();
}
