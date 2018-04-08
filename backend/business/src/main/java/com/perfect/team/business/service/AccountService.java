package com.perfect.team.business.service;

import com.perfect.team.business.model.Account;
import com.perfect.team.business.validation.AccountCreate;
import com.perfect.team.business.validation.AccountId;
import com.perfect.team.business.validation.AccountUpdate;
import com.perfect.team.business.validation.UserId;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AccountService {

  Long create(@AccountCreate Account bean);

  Account read(@AccountId Long id);

  Account update(@AccountUpdate Account bean);

  void delete(@AccountId Long id);

  Collection<Account> readAll();

  Collection<Account> readByUserId(@UserId Long userId);
}
