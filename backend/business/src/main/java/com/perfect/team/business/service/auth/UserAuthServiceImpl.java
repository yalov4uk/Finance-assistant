package com.perfect.team.business.service.auth;

import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.UserService;
import com.perfect.team.business.service.custom.base.CrudService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl extends AuthCrudServiceBase<User> implements UserAuthService {

  @Inject
  private UserService userService;

  @Override
  protected CrudService<User> getService() {
    return userService;
  }

  @Override
  protected Long getUserId(User bean) {
    return bean.getId();
  }

  @Override
  protected void setUserId(User bean, Long userId) {
    bean.setId(userId);
  }

  @Override
  public Long create(User bean) {
    throw new ForbiddenException("Create user not allowed");
  }

  /**
   * Only for dev
   *
   * @return all users
   */
  @Override
  public List<User> readAll() {
    return userService.readAll();
  }
}
