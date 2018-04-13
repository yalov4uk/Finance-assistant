package com.perfect.team.business.service.base;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.mapper.base.CrudMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;

public abstract class CrudServiceBase<T extends Serializable> implements CrudService<T> {

  @Inject
  protected ApplicationEventPublisher applicationEventPublisher;

  protected abstract CrudMapper<T> getMapper();

  protected abstract ChangedBaseEvent<T> getOnChangeEvent(Object source, T oldObject, T newObject);

  protected abstract Long getPrimaryKey(T bean);

  @Override
  public Long create(T bean) {
    getMapper().insert(bean);
    applicationEventPublisher.publishEvent(getOnChangeEvent(this, null, bean));
    return getPrimaryKey(bean);
  }

  @Override
  public T read(Long id) {
    return getMapper().selectById(id);
  }

  @Override
  public T update(T bean) {
    T oldObject = getMapper().selectById(getPrimaryKey(bean));
    getMapper().update(bean);
    T newObject = getMapper().selectById(getPrimaryKey(bean));
    applicationEventPublisher.publishEvent(getOnChangeEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    T oldObject = getMapper().selectById(id);
    getMapper().delete(id);
    applicationEventPublisher.publishEvent(getOnChangeEvent(this, oldObject, null));
  }

  @Override
  public Collection<T> readAll() {
    Collection<T> beans = new ArrayList<>();
    return beans;
  }
}
