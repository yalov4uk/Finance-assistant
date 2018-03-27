package com.perfect.team.business.service.custom.base;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T extends Serializable> {

  Long create(T bean);

  T read(Long id);

  T update(Long id, T bean);

  void delete(Long id);

  List<T> readAll();
}
