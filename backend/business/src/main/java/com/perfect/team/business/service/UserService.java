package com.perfect.team.business.service;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.base.CrudService;

public interface UserService extends CrudService<User> {

    User readByEmail(String email);
}
