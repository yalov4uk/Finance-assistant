package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.User;

public interface UserDao extends CrudDao<User> {

    User readByEmail(String email);
}
