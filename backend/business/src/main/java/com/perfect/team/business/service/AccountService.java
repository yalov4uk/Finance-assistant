package com.perfect.team.business.service;

import com.perfect.team.common.model.Account;
import com.perfect.team.common.model.Account.Currency;
import com.perfect.team.business.validation.constraint.AccountCreate;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.AccountUpdate;
import com.perfect.team.business.validation.constraint.UserId;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AccountService {

  Long create(@AccountCreate Account bean);

  List<Account> read(@AccountId Long id, String name, Currency currency, @UserId Long userId);

  Account update(@AccountUpdate Account bean);

  void delete(@AccountId Long id);
}
