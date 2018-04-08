package com.perfect.team.business.event.base;

import org.springframework.context.ApplicationEvent;

public abstract class ChangedBaseEvent<T> extends ApplicationEvent {

  protected T oldObject;
  protected T newObject;

  public ChangedBaseEvent(Object source, T oldObject, T newObject) {
    super(source);
    this.oldObject = oldObject;
    this.newObject = newObject;
  }

  public T getOldObject() {
    return oldObject;
  }

  public void setOldObject(T oldObject) {
    this.oldObject = oldObject;
  }

  public T getNewObject() {
    return newObject;
  }

  public void setNewObject(T newObject) {
    this.newObject = newObject;
  }
}
