package com.perfect.team.business.service;

import com.perfect.team.business.event.UserChangedEvent;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  private UserMapper userMapper;

  @Inject
  private PasswordEncoder passwordEncoder;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(User bean) {
    bean.setPassword(passwordEncoder.encode(bean.getPassword()));
    userMapper.insert(bean);
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, null, bean));
    return bean.getId();
  }

  @Override
  public List<User> read(Long id, String name, String email) {
    return userMapper.select(id, name, email);
  }

  @Override
  public User update(User bean) {
    User oldObject = userMapper.selectById(bean.getId());
    if (bean.getPassword() != null) {
      bean.setPassword(passwordEncoder.encode(bean.getPassword()));
    }
    userMapper.update(bean);
    User newObject = userMapper.selectById(bean.getId());
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    User oldObject = userMapper.selectById(id);
    userMapper.delete(id);
    applicationEventPublisher.publishEvent(new UserChangedEvent(this, oldObject, null));
  }
}
