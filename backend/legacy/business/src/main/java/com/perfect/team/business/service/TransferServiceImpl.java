package com.perfect.team.business.service;

import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.common.event.TransferChangedEvent;
import com.perfect.team.common.event.TransferCreatedEvent;
import com.perfect.team.common.event.TransferDeletedEvent;
import com.perfect.team.common.model.Transfer;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.jms.Topic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

  @Inject
  private TransferMapper transferMapper;

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Topic topic;

  @Override
  public Long create(Transfer bean) {
    transferMapper.insert(bean);
    jmsTemplate.convertAndSend(topic, new TransferCreatedEvent(this, bean));
    return bean.getId();
  }

  @Override
  public List<Transfer> read(Long id, Date date, Long fromAccountId, Long toAccountId,
      Long userId) {
    return transferMapper.select(id, date, fromAccountId, toAccountId, userId);
  }

  @Override
  public Transfer update(Transfer bean) {
    Transfer oldObject = transferMapper.selectById(bean.getId());
    transferMapper.update(bean);
    Transfer newObject = transferMapper.selectById(bean.getId());
    jmsTemplate.convertAndSend(topic, new TransferChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Transfer oldObject = transferMapper.selectById(id);
    transferMapper.delete(id);
    jmsTemplate.convertAndSend(topic, new TransferDeletedEvent(this, oldObject));
  }
}
