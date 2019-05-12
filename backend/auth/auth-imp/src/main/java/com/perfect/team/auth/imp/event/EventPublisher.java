package com.perfect.team.auth.imp.event;

import com.perfect.team.auth.imp.model.Credential;

public interface EventPublisher {

  void created(Credential cur);

  void updated(Credential old, Credential cur);

  void deleted(Credential old);
}
