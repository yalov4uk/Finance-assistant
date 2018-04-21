package com.perfect.team.business.service;

import com.perfect.team.business.event.TransactionChangedEvent;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.model.Transaction;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Inject
  private TransactionMapper transactionMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(Transaction bean) {
    transactionMapper.insert(bean);
    applicationEventPublisher.publishEvent(new TransactionChangedEvent(this, null, bean));
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
    applicationEventPublisher.publishEvent(new TransactionChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Transaction oldObject = transactionMapper.selectById(id);
    transactionMapper.delete(id);
    applicationEventPublisher.publishEvent(new TransactionChangedEvent(this, oldObject, null));
  }
}
