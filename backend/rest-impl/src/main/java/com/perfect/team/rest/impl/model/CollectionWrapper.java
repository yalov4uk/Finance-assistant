package com.perfect.team.rest.impl.model;

import java.util.Collection;

public class CollectionWrapper<T> {

  private Collection<T> collection;

  public CollectionWrapper(Collection<T> collection) {
    this.collection = collection;
  }

  public Collection<T> getCollection() {
    return collection;
  }

  public void setCollection(Collection<T> collection) {
    this.collection = collection;
  }
}
