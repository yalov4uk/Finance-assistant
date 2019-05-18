package com.perfect.team.credential.imp.event;

import com.perfect.team.credential.imp.model.Credential;

public interface EventPublisher {

  void created(Credential cur);

  void updated(Credential old, Credential cur);

  void deleted(Credential old);
}
