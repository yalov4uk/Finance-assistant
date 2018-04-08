package com.perfect.team.business.service;

import com.perfect.team.business.event.TransferChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.service.base.CrudServiceBase;
import java.math.BigDecimal;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl extends CrudServiceBase<Transfer> implements TransferService {

  @Inject
  private TransferMapper transferMapper;

  @Inject
  private AccountService accountService;

  @Override
  protected CrudMapper<Transfer> getMapper() {
    return transferMapper;
  }

  @Override
  protected ChangedBaseEvent<Transfer> getOnChangeEvent(Object source, Transfer oldObject,
      Transfer newObject) {
    return new TransferChangedEvent(source, oldObject, newObject);
  }

  @Override
  protected Long getPrimaryKey(Transfer bean) {
    return bean.getId();
  }

  @Override
  public Long create(Transfer bean) {
    if (bean.getExchangeRate() == null) {
      bean.setExchangeRate(BigDecimal.ONE);
    }

    if (bean.getFromAccount().getBalance()
        .subtract(bean.getValue()
            .multiply(bean.getExchangeRate()))
        .compareTo(BigDecimal.ZERO) < 0) {
      throw new ValidationException("Insufficient funds");
    }
    bean.getFromAccount().setBalance(bean.getFromAccount().getBalance().subtract(bean.getValue()));
    bean.getToAccount().setBalance(bean.getToAccount().getBalance()
        .add(bean.getValue()
            .multiply(bean.getExchangeRate())));
    accountService.update(bean.getFromAccount());
    accountService.update(bean.getToAccount());
    return super.create(bean);
  }

  @Override
  public Collection<Transfer> readByUserId(Long userId) {
    Collection<Transfer> transfers = transferMapper.selectByUserId(userId);
    validate(transfers);
    return transfers;
  }
}
