package com.perfect.team.business.listener;

import com.perfect.team.business.event.CategoryChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CategoryChangedListener {

  @Async
  @EventListener
  public void onApplicationEvent(CategoryChangedEvent event) {
  }
}
