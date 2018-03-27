package com.perfect.team.business.service.auth.base;

import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.custom.base.CrudService;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class AuthCrudServiceBase<T extends Serializable> implements AuthCrudService<T> {

  protected abstract CrudService<T> getService();

  protected abstract Long getUserId(T bean);

  protected abstract void setUserId(T bean, Long userId);

  @Override
  public Long create(T bean) {
    setUserId(bean, getCurrentUser().getId());
    return getService().create(bean);
  }

  @Override
  public T read(Long id) {
    T bean = getService().read(id);
    if (!Objects.equals(getCurrentUser().getId(), getUserId(bean))) {
      throw new ForbiddenException("Read another's resources not allowed");
    }
    return bean;
  }

  @Override
  public T update(Long id, T bean) {
    setUserId(bean, getCurrentUser().getId());
    return getService().update(id, bean);
  }

  @Override
  public void delete(Long id) {
    read(id);
    getService().delete(id);
  }

  @Override
  public List<T> readAll() {
    return getService().readAll();
  }

  protected User getCurrentUser() {
//        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
//                .getContext()
//                .getAuthentication()
//                .getPrincipal();
//        return userDetails.getUser();
    return null;
  }
}
