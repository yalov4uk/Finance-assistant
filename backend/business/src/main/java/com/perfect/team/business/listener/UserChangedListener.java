package com.perfect.team.business.listener;

import com.perfect.team.business.event.UserChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserChangedListener {

  @Async
  @EventListener
  public void onApplicationEvent(UserChangedEvent event) {
  }
}
