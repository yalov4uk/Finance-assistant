package com.perfect.team.business.service;

import com.perfect.team.business.event.UserChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.exception.NotFoundException;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.base.CrudServiceBase;
import java.util.Collection;
import java.util.Objects;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  private UserMapper userMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(User bean) {
    userMapper.insert(bean);
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, null, bean));
    return bean.getId();
  }

  @Override
  public User read(Long id) {
    return userMapper.select(id);
  }

  @Override
  public User update(User bean) {
    User oldObject = userMapper.select(bean.getId());
    userMapper.update(bean);
    User newObject = userMapper.select(bean.getId());
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    User oldObject = userMapper.select(id);
    userMapper.delete(id);
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, oldObject, null));
  }

  @Override
  public Collection<User> readAll() {
    Collection<User> beans = userMapper.selectAll();
    validate(beans);
    return beans;
  }

  private void validate(Collection<User> beans) {
    if (Objects.isNull(beans) || beans.isEmpty()) {
      throw new NotFoundException();
    }
  }
}
