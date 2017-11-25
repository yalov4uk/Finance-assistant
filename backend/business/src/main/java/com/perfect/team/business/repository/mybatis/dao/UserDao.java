package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDao;

public interface UserDao extends CrudDao<User> {

    User readByEmail(String email);
}
