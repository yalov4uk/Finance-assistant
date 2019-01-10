package com.perfect.team.common.api.event;

import lombok.Data;

@Data
public abstract class ChangedBaseEvent<T> {

  private final T old;
  private final T cur;
}
