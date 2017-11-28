package com.perfect.team.business.service;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl extends CrudServiceBase<User> implements UserService {

    @Inject
    private UserMapper userMapper;

    @Override
    protected CrudMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public User readByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
