package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.api.rest.response.entity.UserResponse;
import com.perfect.team.api.rest.response.entity.UsersResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface UserRestService extends CrudRestService<UserRequest, UserResponse, UsersResponse> {
}
