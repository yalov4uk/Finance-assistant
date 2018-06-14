package com.perfect.team.business.event;

import com.perfect.team.business.model.Category;

public class CategoryCreatedEvent extends CategoryChangedEvent {

  public CategoryCreatedEvent(Object source, Category newObject) {
    super(source, null, newObject);
  }
}
