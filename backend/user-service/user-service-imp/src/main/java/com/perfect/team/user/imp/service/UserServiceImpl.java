package com.perfect.team.user.imp.service;

import com.perfect.team.user.imp.event.EventPublisher;
import com.perfect.team.user.imp.model.User;
import com.perfect.team.user.imp.repository.UserMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  private final EventPublisher eventPublisher;

  @Override
  public Long create(User bean) {
    userMapper.insert(bean);
    eventPublisher.created(bean);
    return bean.getId();
  }

  @Override
  public List<User> read(User bean) {
    return userMapper.select(bean.getId(), bean.getName());
  }

  @Override
  public User update(User bean) {
    User oldObject = userMapper.selectById(bean.getId());
    userMapper.update(bean);
    User newObject = userMapper.selectById(bean.getId());
    eventPublisher.updated(oldObject, newObject);
    return newObject;
  }

  @Override
  public void delete(Long id) {
    User oldObject = userMapper.selectById(id);
    userMapper.delete(id);
    eventPublisher.deleted(oldObject);
  }
}
