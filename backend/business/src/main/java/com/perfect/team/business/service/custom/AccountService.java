package com.perfect.team.business.service.custom;

import com.perfect.team.business.model.Account;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AccountService {

  Long create(Account account);

  Account read(Long id);

  Account update(Long id, Account account);

  void delete(Long id);

  List<Account> readAll();

  List<Account> readAllByUserId(Long userId);
}
