package com.perfect.team.service.api;

import com.perfect.team.service.request.IdRequest;
import com.perfect.team.service.request.UserUpdateRequest;
import com.perfect.team.service.request.base.AuthRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.UserResponse;
import com.perfect.team.service.validation.UserId;
import com.perfect.team.service.validation.UserUpdate;

public interface UserService {
    UserResponse read(@UserId IdRequest request);

    UserResponse update(@UserUpdate UserUpdateRequest request);

    void delete(@UserId IdRequest request);

    CategoriesResponse readAll(AuthRequest request);
}
