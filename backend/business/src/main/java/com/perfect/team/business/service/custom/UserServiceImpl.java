package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
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
    protected Long getBeanId(User bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, User bean) {
        bean.setId(id);
    }

    @Override
    public User readByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
