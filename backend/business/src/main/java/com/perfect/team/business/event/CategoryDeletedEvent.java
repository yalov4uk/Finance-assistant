package com.perfect.team.business.event;

import com.perfect.team.business.model.Category;

public class CategoryDeletedEvent extends CategoryChangedEvent {

  public CategoryDeletedEvent(Object source, Category oldObject) {
    super(source, oldObject, null);
  }
}
