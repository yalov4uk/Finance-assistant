package com.perfect.team.business.event;

import com.perfect.team.common.model.Confirmation;
import org.springframework.context.ApplicationEvent;

public class EmailConfirmedEvent extends ApplicationEvent {

  private final Confirmation confirmation;

  public EmailConfirmedEvent(Object source, Confirmation confirmation) {
    super(source);
    this.confirmation = confirmation;
  }

  public Confirmation getConfirmation() {
    return confirmation;
  }
}
