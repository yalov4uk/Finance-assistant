package com.perfect.team.business.service.custom;

import com.perfect.team.business.model.User;
import com.perfect.team.business.service.custom.base.CrudService;

public interface UserService extends CrudService<User> {

  User readByEmail(String email);
}
