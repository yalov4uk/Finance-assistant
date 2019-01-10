package com.perfect.team.auth.imp.service;

import com.perfect.team.auth.api.dto.CredentialDto;
import com.perfect.team.auth.api.event.CredentialChangedEvent;
import com.perfect.team.auth.api.event.CredentialCreatedEvent;
import com.perfect.team.auth.api.event.CredentialDeletedEvent;
import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.repository.CredentialMapper;
import java.util.List;
import javax.jms.Topic;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CredentialServiceImpl implements CredentialService {

  private final CredentialMapper credentialMapper;
  private final JmsTemplate jmsTemplate;
  private final Topic topic;
  private final Mapper mapper;

  @Override
  public Long create(Credential bean) {
    credentialMapper.insert(bean);
    jmsTemplate
        .convertAndSend(topic, new CredentialCreatedEvent(mapper.map(bean, CredentialDto.class)));
    return bean.getId();
  }

  @Override
  public List<Credential> read(Long id, String username, Boolean confirmed, Long userId) {
    return credentialMapper.select(id, username, confirmed, userId);
  }

  @Override
  public Credential update(Credential bean) {
    Credential oldObject = credentialMapper.selectById(bean.getId());
    credentialMapper.update(bean);
    Credential newObject = credentialMapper.selectById(bean.getId());
    jmsTemplate.convertAndSend(topic,
        new CredentialChangedEvent(mapper.map(oldObject, CredentialDto.class),
            mapper.map(newObject, CredentialDto.class)));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Credential oldObject = credentialMapper.selectById(id);
    credentialMapper.delete(id);
    jmsTemplate.convertAndSend(topic,
        new CredentialDeletedEvent(mapper.map(oldObject, CredentialDto.class)));
  }
}
