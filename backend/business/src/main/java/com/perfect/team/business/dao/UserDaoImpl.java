package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDaoBase;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class UserDaoImpl extends CrudDaoBase<User> implements UserDao {

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
