package com.perfect.team.business.service;

import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.service.base.CrudService;
import com.perfect.team.business.validation.TransferCreate;
import com.perfect.team.business.validation.TransferId;
import com.perfect.team.business.validation.TransferUpdate;
import com.perfect.team.business.validation.UserId;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TransferService extends CrudService<Transfer> {

  Long create(@TransferCreate Transfer bean);

  Transfer read(@TransferId Long id);

  Transfer update(@TransferUpdate Transfer bean);

  void delete(@TransferId Long id);

  Collection<Transfer> readAll();

  Collection<Transfer> readByUserId(@UserId Long userId);
}
