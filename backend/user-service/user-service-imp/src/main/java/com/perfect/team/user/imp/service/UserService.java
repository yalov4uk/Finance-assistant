package com.perfect.team.user.imp.service;


import com.perfect.team.user.imp.model.User;
import com.perfect.team.user.imp.validation.constraint.UserCreate;
import com.perfect.team.user.imp.validation.constraint.UserId;
import com.perfect.team.user.imp.validation.constraint.UserRead;
import com.perfect.team.user.imp.validation.constraint.UserUpdate;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  Long create(@UserCreate User bean);

  List<User> read(@UserRead User bean);

  User update(@UserUpdate User bean);

  void delete(@UserId Long id);
}
