package com.perfect.team.user.imp.event;

import com.perfect.team.user.imp.model.User;

public interface EventPublisher {

  void created(User cur);

  void updated(User old, User cur);

  void deleted(User old);
}
