package com.perfect.team.business.service.custom.base;

import com.perfect.team.business.mapper.base.CrudMapper;
import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceBase<T extends Serializable> implements CrudService<T> {

  protected abstract CrudMapper<T> getMapper();

  protected abstract Long getBeanId(T bean);

  protected abstract void setBeanId(Long id, T bean);

  @Override
  public Long create(T bean) {
    int insertedCount = getMapper().insert(bean);
    return getBeanId(bean);
  }

  @Override
  public T read(Long id) {
    return getMapper().select(id);
  }

  @Override
  public T update(Long id, T bean) {
    setBeanId(id, bean);
    int updatedCount = getMapper().update(bean);
    return read(id);
  }

  @Override
  public void delete(Long id) {
    int deletedRows = getMapper().delete(id);
  }

  @Override
  public List<T> readAll() {
    return getMapper().selectAll();
  }
}
