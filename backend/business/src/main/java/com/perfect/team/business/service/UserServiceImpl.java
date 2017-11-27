package com.perfect.team.business.service;

import com.perfect.team.business.dao.UserDao;
import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl extends CrudServiceBase<User> implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    protected CrudDao<User> getDao() {
        return userDao;
    }

    @Override
    public User readByEmail(String email) {
        return userDao.readByEmail(email);
    }
}
