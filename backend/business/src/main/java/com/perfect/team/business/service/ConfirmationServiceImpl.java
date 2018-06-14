package com.perfect.team.business.service;

import com.perfect.team.business.event.ConfirmationCreatedEvent;
import com.perfect.team.business.event.EmailConfirmedEvent;
import com.perfect.team.business.mapper.ConfirmationMapper;
import com.perfect.team.business.model.Confirmation;
import javax.inject.Inject;
import javax.jms.Topic;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

  @Inject
  private ConfirmationMapper confirmationMapper;

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Topic topic;

  @Override
  public Long create(Confirmation bean) {
    bean.setCode(RandomStringUtils.randomAlphanumeric(64));
    confirmationMapper.insert(bean);
    jmsTemplate.convertAndSend(topic, new ConfirmationCreatedEvent(this, bean));
    return bean.getId();
  }

  @Override
  public Confirmation update(Confirmation bean) {
    Confirmation oldObject = confirmationMapper
        .selectByCodeAndUserId(bean.getCode(), bean.getUser().getId());
    bean.setId(oldObject.getId());
    confirmationMapper.update(bean);
    Confirmation newObject = confirmationMapper
        .selectByCodeAndUserId(bean.getCode(), bean.getUser().getId());
    jmsTemplate.convertAndSend(topic, new EmailConfirmedEvent(this, bean));
    return newObject;
  }
}
