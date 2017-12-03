package com.perfect.team.impl.rest.service;

import com.perfect.team.api.rest.dto.entity.UserDto;
import com.perfect.team.api.rest.request.entity.UserRequest;
import com.perfect.team.api.rest.response.entity.UserResponse;
import com.perfect.team.api.rest.response.entity.UsersResponse;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.auth.UserAuthService;
import com.perfect.team.business.service.custom.base.CrudService;
import com.perfect.team.impl.rest.service.base.CrudRestServiceBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserRestServiceImpl
        extends CrudRestServiceBase<UserRequest, User, UserResponse, UsersResponse>
        implements UserRestService {

    @Inject
    private UserAuthService userService;

    @Override
    protected CrudService<User> getService() {
        return userService;
    }

    @Override
    protected User mapRequestToEntity(UserRequest request) {
        return modelMapper.map(request.getUserDto(), User.class);
    }

    @Override
    protected UserResponse mapEntityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserDto(modelMapper.map(user, UserDto.class));
        return userResponse;
    }

    @Override
    protected UsersResponse mapEntitiesToListResponse(List<User> users) {
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setUserDtos(users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList()));
        return usersResponse;
    }
}
