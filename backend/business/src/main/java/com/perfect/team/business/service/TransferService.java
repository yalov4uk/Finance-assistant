package com.perfect.team.business.service;

import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.validation.constraint.AccountId;
import com.perfect.team.business.validation.constraint.TransferCreate;
import com.perfect.team.business.validation.constraint.TransferId;
import com.perfect.team.business.validation.constraint.TransferUpdate;
import com.perfect.team.business.validation.constraint.UserId;
import java.util.Date;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransferService {

  Long create(@TransferCreate Transfer bean);

  List<Transfer> read(@TransferId Long id, Date date, @AccountId Long fromAccountId,
      Long toAccountId, @UserId Long userId);

  Transfer update(@TransferUpdate Transfer bean);

  void delete(@TransferId Long id);
}
