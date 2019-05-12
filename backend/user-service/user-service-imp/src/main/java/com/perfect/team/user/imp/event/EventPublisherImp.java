package com.perfect.team.user.imp.event;

import com.perfect.team.user.api.dto.UserDto;
import com.perfect.team.user.api.event.UserChangedEvent;
import com.perfect.team.user.api.event.UserCreatedEvent;
import com.perfect.team.user.api.event.UserDeletedEvent;
import com.perfect.team.user.imp.model.User;
import javax.jms.Topic;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherImp implements EventPublisher {

  private final JmsTemplate jmsTemplate;
  private final Topic topic;
  private final Mapper mapper;

  @Override
  public void created(User cur) {
    jmsTemplate
        .convertAndSend(topic, new UserCreatedEvent(mapper.map(cur, UserDto.class)));
  }

  @Override
  public void updated(User old, User cur) {
    jmsTemplate.convertAndSend(topic,
        new UserChangedEvent(mapper.map(old, UserDto.class),
            mapper.map(cur, UserDto.class)));
  }

  @Override
  public void deleted(User old) {
    jmsTemplate.convertAndSend(topic, new UserDeletedEvent(mapper.map(old, UserDto.class)));
  }
}
