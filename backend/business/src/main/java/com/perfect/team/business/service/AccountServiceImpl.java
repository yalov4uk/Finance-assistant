package com.perfect.team.business.service;

import com.perfect.team.business.event.AccountChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Account;
import com.perfect.team.business.service.base.CrudServiceBase;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CrudServiceBase<Account> implements AccountService {

  @Inject
  private AccountMapper accountMapper;

  @Override
  protected CrudMapper<Account> getMapper() {
    return accountMapper;
  }

  @Override
  protected ChangedBaseEvent<Account> getOnChangeEvent(Object source, Account oldObject,
      Account newObject) {
    return new AccountChangedEvent(source, oldObject, newObject);
  }

  @Override
  protected Long getPrimaryKey(Account bean) {
    return bean.getId();
  }

  @Override
  public Long create(Account bean) {
    if (Arrays
        .stream(Account.Currency.values())
        .noneMatch(currency -> Objects.equals(currency, bean.getCurrency()))) {
      bean.setCurrency(Account.Currency.BYN);
    }

    return super.create(bean);
  }

  @Override
  public Collection<Account> readByUserId(Long userId) {
    Collection<Account> accounts = accountMapper.selectByUserId(userId);
    validate(accounts);
    return accounts;
  }
}
