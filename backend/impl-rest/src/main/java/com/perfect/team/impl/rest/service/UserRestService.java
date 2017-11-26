package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.api.rest.response.UsersResponse;
import com.perfect.team.impl.rest.service.base.CrudRestService;

public interface UserRestService extends CrudRestService<UserRequest, UserResponse, UsersResponse> {
}
