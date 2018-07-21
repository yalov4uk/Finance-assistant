package com.perfect.team.business.service;

import com.perfect.team.common.model.User;
import com.perfect.team.business.validation.constraint.UserCreate;
import com.perfect.team.business.validation.constraint.UserId;
import com.perfect.team.business.validation.constraint.UserUpdate;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  Long create(@UserCreate User bean);

  List<User> read(@UserId Long id, String name, String email);

  User update(@UserUpdate User bean);

  void delete(@UserId Long id);
}
