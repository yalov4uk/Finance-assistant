package com.perfect.team.business.service.helper;

import com.perfect.team.business.model.Transaction;

public interface AccountBalanceHelper {

  void updateOnCreate(Transaction transaction);

  void updateOnUpdate(Long id, Transaction transaction);

  void updateOnDelete(Long id);
}
