package com.perfect.team.business.service;

import com.perfect.team.business.mapper.AccountMapper;
import com.perfect.team.common.event.AccountChangedEvent;
import com.perfect.team.common.event.AccountCreatedEvent;
import com.perfect.team.common.event.AccountDeletedEvent;
import com.perfect.team.common.model.Account;
import com.perfect.team.common.model.Account.Currency;
import java.util.List;
import javax.inject.Inject;
import javax.jms.Topic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Inject
  private AccountMapper accountMapper;

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Topic topic;

  @Override
  public Long create(Account bean) {
    accountMapper.insert(bean);
    jmsTemplate.convertAndSend(topic, new AccountCreatedEvent(this, bean));
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
    jmsTemplate.convertAndSend(topic, new AccountChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Account oldObject = accountMapper.selectById(id);
    accountMapper.delete(id);
    jmsTemplate.convertAndSend(topic, new AccountDeletedEvent(this, oldObject));
  }
}
