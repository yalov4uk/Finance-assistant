package com.perfect.team.business.service;

import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.validation.constraint.TransactionCreate;
import com.perfect.team.business.validation.constraint.TransactionId;
import com.perfect.team.business.validation.constraint.TransactionUpdate;
import com.perfect.team.business.validation.constraint.UserId;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransactionService {

  Long create(@TransactionCreate Transaction bean);

  Transaction read(@TransactionId Long id);

  Transaction update(@TransactionUpdate Transaction bean);

  void delete(@TransactionId Long id);

  Collection<Transaction> readAll();

  Collection<Transaction> readByUserId(@UserId Long userId);
}
