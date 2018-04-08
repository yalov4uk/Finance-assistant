package com.perfect.team.business.service;

import com.perfect.team.business.event.UserChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.base.CrudServiceBase;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceBase<User> implements UserService {

  @Inject
  private UserMapper userMapper;

  @Override
  protected CrudMapper<User> getMapper() {
    return userMapper;
  }

  @Override
  protected ChangedBaseEvent<User> getOnChangeEvent(Object source, User oldObject,
      User newObject) {
    return new UserChangedEvent(source, oldObject, newObject);
  }

  @Override
  protected Long getPrimaryKey(User bean) {
    return bean.getId();
  }

  @Override
  public User readByEmail(String email) {
    return userMapper.selectByEmail(email);
  }
}
