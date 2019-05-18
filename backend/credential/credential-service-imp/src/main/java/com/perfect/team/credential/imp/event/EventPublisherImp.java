package com.perfect.team.credential.imp.event;

import com.perfect.team.credential.api.dto.CredentialDto;
import com.perfect.team.credential.api.event.CredentialChangedEvent;
import com.perfect.team.credential.api.event.CredentialCreatedEvent;
import com.perfect.team.credential.api.event.CredentialDeletedEvent;
import com.perfect.team.credential.imp.model.Credential;
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
  public void created(Credential cur) {
    jmsTemplate
        .convertAndSend(topic, new CredentialCreatedEvent(mapper.map(cur, CredentialDto.class)));
  }

  @Override
  public void updated(Credential old, Credential cur) {
    jmsTemplate.convertAndSend(topic,
        new CredentialChangedEvent(mapper.map(old, CredentialDto.class),
            mapper.map(cur, CredentialDto.class)));
  }

  @Override
  public void deleted(Credential old) {
    jmsTemplate
        .convertAndSend(topic, new CredentialDeletedEvent(mapper.map(old, CredentialDto.class)));
  }
}
