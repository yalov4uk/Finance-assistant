package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.response.UserResponse;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRestServiceImpl implements UserRestService {

    @Inject
    private UserService userService;

    @Inject
    private UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userService.findAll();
        return users.stream().map(userMapper::mapEntity).collect(Collectors.toList());
    }
}
