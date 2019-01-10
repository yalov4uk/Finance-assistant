package com.perfect.team.common.util;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CollectionWrapper<T> {

  private Collection<T> collection;
}
