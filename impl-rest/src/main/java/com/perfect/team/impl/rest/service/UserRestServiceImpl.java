package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.model.entity.UserDto;
import com.perfect.team.api.rest.response.UsersResponse;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRestServiceImpl extends CrudRestServiceImpl implements UserRestService {

    @Inject
    private UserService userService;

    @Override
    public UsersResponse findAll() {
        List<User> users = userService.findAll();
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setUserDtos(users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList()));
        return usersResponse;
    }
}
