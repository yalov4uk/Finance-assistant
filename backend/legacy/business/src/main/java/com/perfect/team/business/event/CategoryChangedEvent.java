package com.perfect.team.business.event;

import com.perfect.team.common.model.Category;

public class CategoryChangedEvent extends
    com.perfect.team.business.event.base.ChangedBaseEvent<Category> {

  public CategoryChangedEvent(Object source, Category oldObject, Category newObject) {
    super(source, oldObject, newObject);
  }
}
