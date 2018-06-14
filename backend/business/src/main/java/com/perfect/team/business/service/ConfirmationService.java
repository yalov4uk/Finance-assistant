package com.perfect.team.business.service;

import com.perfect.team.business.model.Confirmation;
import com.perfect.team.business.validation.constraint.ConfirmationCreate;
import com.perfect.team.business.validation.constraint.ConfirmationUpdate;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ConfirmationService {

  Long create(@ConfirmationCreate Confirmation bean);

  Confirmation update(@ConfirmationUpdate Confirmation bean);
}
