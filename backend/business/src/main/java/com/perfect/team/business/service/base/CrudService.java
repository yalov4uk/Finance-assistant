package com.perfect.team.business.service.base;

import java.io.Serializable;
import java.util.Collection;

public interface CrudService<T extends Serializable> {

  Long create(T bean);

  T read(Long id);

  T update(T bean);

  void delete(Long id);

  Collection<T> readAll();
}
