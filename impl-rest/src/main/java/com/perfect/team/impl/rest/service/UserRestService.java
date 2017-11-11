package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.response.UserResponse;

import java.util.List;

public interface UserRestService {

    List<UserResponse> findAll();
}
