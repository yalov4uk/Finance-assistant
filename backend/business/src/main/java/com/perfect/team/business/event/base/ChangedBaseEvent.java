package com.perfect.team.business.event.base;

import org.springframework.context.ApplicationEvent;

public abstract class ChangedBaseEvent<T> extends ApplicationEvent {

  protected T old;
  protected T cur;

  public ChangedBaseEvent(Object source, T old, T cur) {
    super(source);
    this.old = old;
    this.cur = cur;
  }

  public T getOld() {
    return old;
  }

  public void setOld(T old) {
    this.old = old;
  }

  public T getCur() {
    return cur;
  }

  public void setCur(T cur) {
    this.cur = cur;
  }
}
