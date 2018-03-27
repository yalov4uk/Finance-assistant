package com.perfect.team.business.service.custom;

import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.model.Account;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Inject
  private AccountMapper accountMapper;

  @Override
  public Long create(Account bean) {
    if (Arrays
        .stream(Account.Currency.values())
        .noneMatch(currency -> Objects.equals(currency, bean.getCurrency()))) {
      bean.setCurrency(Account.Currency.BYN);
    }
    accountMapper.insert(bean);
    return bean.getId();
  }

  @Override
  public Account read(Long id) {
    return null;
  }

  @Override
  public Account update(Long id, Account account) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Account> readAll() {
    return null;
  }

  @Override
  public List<Account> readAllByUserId(Long userId) {
    return accountMapper.selectAllByUserId(userId);
  }
}
