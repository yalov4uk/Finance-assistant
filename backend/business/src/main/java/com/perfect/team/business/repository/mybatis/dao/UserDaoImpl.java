package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDaoImpl;
import com.perfect.team.business.repository.mybatis.mapper.UserMapper;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class UserDaoImpl extends CrudDaoImpl<User> implements UserDao {

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
