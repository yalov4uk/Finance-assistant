package com.perfect.team.business.service;

import com.perfect.team.business.event.ConfirmationChangedEvent;
import com.perfect.team.business.mapper.ConfirmationMapper;
import com.perfect.team.business.model.Confirmation;
import javax.inject.Inject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

  @Inject
  private ConfirmationMapper confirmationMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(Confirmation bean) {
    bean.setCode(RandomStringUtils.randomAlphanumeric(64));
    confirmationMapper.insert(bean);
    applicationEventPublisher.publishEvent(new ConfirmationChangedEvent(this, null, bean));
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
    applicationEventPublisher
        .publishEvent(new ConfirmationChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Confirmation oldObject = confirmationMapper.selectById(id);
    confirmationMapper.delete(id);
    applicationEventPublisher.publishEvent(new ConfirmationChangedEvent(this, oldObject, null));
  }
}
