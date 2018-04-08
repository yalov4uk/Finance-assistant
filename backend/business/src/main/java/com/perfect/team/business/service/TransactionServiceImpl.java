package com.perfect.team.business.service;

import com.perfect.team.business.event.TransactionChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.service.base.CrudServiceBase;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements
    TransactionService {

  @Inject
  private TransactionMapper transactionMapper;

  @Override
  protected CrudMapper<Transaction> getMapper() {
    return transactionMapper;
  }

  @Override
  protected ChangedBaseEvent<Transaction> getOnChangeEvent(Object source, Transaction oldObject,
      Transaction newObject) {
    return new TransactionChangedEvent(source, oldObject, newObject);
  }

  @Override
  protected Long getPrimaryKey(Transaction bean) {
    return bean.getId();
  }

  @Override
  public Collection<Transaction> readByUserId(Long userId) {
    Collection<Transaction> transactions = transactionMapper.selectByUserId(userId);
    validate(transactions);
    return transactions;
  }
}
