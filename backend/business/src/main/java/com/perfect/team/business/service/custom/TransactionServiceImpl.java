package com.perfect.team.business.service.custom;

import com.perfect.team.business.mapper.TransactionMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import com.perfect.team.business.service.helper.AccountBalanceHelper;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CrudServiceBase<Transaction> implements
    TransactionService {

  @Inject
  private TransactionMapper transactionMapper;

  @Inject
  private AccountBalanceHelper accountBalanceHelper;

  @Override
  protected CrudMapper<Transaction> getMapper() {
    return transactionMapper;
  }

  @Override
  protected Long getBeanId(Transaction bean) {
    return bean.getId();
  }

  @Override
  protected void setBeanId(Long id, Transaction bean) {
    bean.setId(id);
  }

  @Override
  public Long create(Transaction bean) {
    accountBalanceHelper.updateOnCreate(bean);
    return super.create(bean);
  }

  @Override
  public Transaction update(Long id, Transaction bean) {
    accountBalanceHelper.updateOnUpdate(id, bean);
    return super.update(id, bean);
  }

  @Override
  public void delete(Long id) {
    accountBalanceHelper.updateOnDelete(id);
    super.delete(id);
  }

  @Override
  public List<Transaction> readAllByUserId(Long userId) {
    return transactionMapper.selectAllByUserId(userId);
  }
}
