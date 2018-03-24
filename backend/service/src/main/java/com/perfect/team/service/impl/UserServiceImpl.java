package com.perfect.team.service.impl;

import com.perfect.team.service.api.UserService;
import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.UserUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.UserResponse;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse read(IdRequest request) {
        return null;
    }

    @Override
    public UserResponse update(UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(IdRequest request) {

    }

    @Override
    public CategoriesResponse readAll(AuthRequest request) {
        return null;
    }
}
