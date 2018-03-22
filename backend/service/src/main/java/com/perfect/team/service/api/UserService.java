package com.perfect.team.service.api;

import com.perfect.team.service.request.UserUpdateRequest;
import com.perfect.team.service.response.CategoriesResponse;
import com.perfect.team.service.response.UserResponse;
import com.perfect.team.service.validation.UserId;
import com.perfect.team.service.validation.UserUpdate;

public interface UserService {
    UserResponse read(@UserId Long id);

    UserResponse update(@UserId Long id, @UserUpdate UserUpdateRequest request);

    void delete(@UserId Long id);

    CategoriesResponse readAll();
}
