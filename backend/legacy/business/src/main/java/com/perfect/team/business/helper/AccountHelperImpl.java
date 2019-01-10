package com.perfect.team.business.helper;

import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.business.service.AccountService;
import com.perfect.team.common.model.Account;
import java.math.BigDecimal;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class AccountHelperImpl implements AccountHelper {

  @Inject
  private AccountMapper accountMapper;

  @Inject
  private AccountService accountService;

  @Override
  public void incBalance(Long accountId, BigDecimal value) {
    incBalance(accountId, value, BigDecimal.ONE);
  }

  @Override
  public void incBalance(Long accountId, BigDecimal value, BigDecimal exchangeRate) {
    Account account = accountMapper.selectById(accountId);
    account.setBalance(account.getBalance().add(value.multiply(exchangeRate)));
    accountService.update(account);
  }
}
