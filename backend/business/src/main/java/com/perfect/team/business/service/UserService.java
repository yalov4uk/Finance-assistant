package com.perfect.team.business.service;

import com.perfect.team.business.model.User;
import com.perfect.team.business.validation.constraint.UserCreate;
import com.perfect.team.business.validation.constraint.UserId;
import com.perfect.team.business.validation.constraint.UserUpdate;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  Long create(@UserCreate User bean);

  User read(@UserId Long id);

  User update(@UserUpdate User bean);

  void delete(@UserId Long id);

  Collection<User> readAll();
}
