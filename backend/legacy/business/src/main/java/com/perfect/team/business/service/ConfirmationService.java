package com.perfect.team.business.service;

import com.perfect.team.business.validation.constraint.ConfirmationConfirm;
import com.perfect.team.business.validation.constraint.ConfirmationCreate;
import com.perfect.team.common.model.Confirmation;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ConfirmationService {

  Long create(@ConfirmationCreate Confirmation bean);

  void confirm(@ConfirmationConfirm Confirmation bean);
}
