package com.perfect.team.business.service;

import com.perfect.team.business.event.TransactionChangedEvent;
import com.perfect.team.business.event.TransactionCreatedEvent;
import com.perfect.team.business.event.TransactionDeletedEvent;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.common.model.Transaction;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.jms.Topic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Inject
  private TransactionMapper transactionMapper;

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Topic topic;

  @Override
  public Long create(Transaction bean) {
    transactionMapper.insert(bean);
    jmsTemplate.convertAndSend(topic, new TransactionCreatedEvent(this, bean));
    return bean.getId();
  }

  @Override
  public List<Transaction> read(Long id, Date date, Long categoryId, Long accountId, Long userId) {
    return transactionMapper.select(id, date, categoryId, accountId, userId);
  }

  @Override
  public Transaction update(Transaction bean) {
    Transaction oldObject = transactionMapper.selectById(bean.getId());
    transactionMapper.update(bean);
    Transaction newObject = transactionMapper.selectById(bean.getId());
    jmsTemplate.convertAndSend(topic, new TransactionChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Transaction oldObject = transactionMapper.selectById(id);
    transactionMapper.delete(id);
    jmsTemplate.convertAndSend(topic, new TransactionDeletedEvent(this, oldObject));
  }
}
