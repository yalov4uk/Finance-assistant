package com.perfect.team.impl.rest.mapper;

import com.perfect.team.api.rest.request.UserRequest;
import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.User;
import com.perfect.team.impl.rest.mapper.base.RestMapperImpl;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends RestMapperImpl<UserRequest, User, UserResponse> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }
}
