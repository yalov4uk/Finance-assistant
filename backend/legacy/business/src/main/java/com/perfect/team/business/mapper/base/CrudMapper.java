package com.perfect.team.business.mapper.base;

import java.io.Serializable;

public interface CrudMapper<T extends Serializable> {

  int insert(T bean);

  T selectById(Long id);

  int update(T bean);

  int delete(Long id);
}
