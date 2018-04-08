package com.perfect.team.business.service.base;

import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.exception.NotFoundException;
import com.perfect.team.business.mapper.base.CrudMapper;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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
    T bean = getMapper().select(id);
    validate(bean);
    return bean;
  }

  @Override
  public T update(T bean) {
    T oldObject = getMapper().select(getPrimaryKey(bean));
    validate(bean);
    getMapper().update(bean);
    T newObject = getMapper().select(getPrimaryKey(bean));
    applicationEventPublisher.publishEvent(getOnChangeEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    T oldObject = getMapper().select(id);
    validate(oldObject);
    getMapper().delete(id);
    applicationEventPublisher.publishEvent(getOnChangeEvent(this, oldObject, null));
  }

  @Override
  public Collection<T> readAll() {
    Collection<T> beans = getMapper().selectAll();
    validate(beans);
    return beans;
  }

  protected void validate(T bean) {
    if (Objects.isNull(bean)) {
      throw new NotFoundException();
    }
  }

  protected void validate(Collection<T> beans) {
    if (Objects.isNull(beans) || beans.isEmpty()) {
      throw new NotFoundException();
    }
  }
}
