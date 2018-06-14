package com.perfect.team.business.service;

import com.perfect.team.business.event.UserChangedEvent;
import com.perfect.team.business.event.UserCreatedEvent;
import com.perfect.team.business.event.UserDeletedEvent;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.User;
import java.util.List;
import javax.inject.Inject;
import javax.jms.Topic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  private UserMapper userMapper;

  @Inject
  private PasswordEncoder passwordEncoder;

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Topic topic;

  @Override
  public Long create(User bean) {
    bean.setPassword(passwordEncoder.encode(bean.getPassword()));
    userMapper.insert(bean);
    jmsTemplate.convertAndSend(topic, new UserCreatedEvent(this, bean));
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
    jmsTemplate.convertAndSend(topic, new UserChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    User oldObject = userMapper.selectById(id);
    userMapper.delete(id);
    jmsTemplate.convertAndSend(topic, new UserDeletedEvent(this, oldObject));
  }
}
