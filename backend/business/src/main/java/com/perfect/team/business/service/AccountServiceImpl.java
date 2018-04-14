package com.perfect.team.business.service;

import com.perfect.team.business.event.AccountChangedEvent;
import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.model.Account;
import com.perfect.team.business.model.Account.Currency;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Inject
  private AccountMapper accountMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(Account bean) {
    accountMapper.insert(bean);
    applicationEventPublisher.publishEvent(new AccountChangedEvent(this, null, bean));
    return bean.getId();
  }

  @Override
  public List<Account> read(Long id, String name, Currency currency, Long userId) {
    return accountMapper.select(id, name, currency, userId);
  }

  @Override
  public Account update(Account bean) {
    Account oldObject = accountMapper.selectById(bean.getId());
    accountMapper.update(bean);
    Account newObject = accountMapper.selectById(bean.getId());
    applicationEventPublisher.publishEvent(new AccountChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Account oldObject = accountMapper.selectById(id);
    accountMapper.delete(id);
    applicationEventPublisher.publishEvent(new AccountChangedEvent(this, oldObject, null));
  }
}
