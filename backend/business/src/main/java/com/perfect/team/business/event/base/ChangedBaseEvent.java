package com.perfect.team.business.event.base;

import org.springframework.context.ApplicationEvent;

public abstract class ChangedBaseEvent<T> extends ApplicationEvent {

  private final T old;
  private final T cur;

  public ChangedBaseEvent(Object source, T old, T cur) {
    super(source);
    this.old = old;
    this.cur = cur;
  }

  public T getOld() {
    return old;
  }

  public T getCur() {
    return cur;
  }
}
