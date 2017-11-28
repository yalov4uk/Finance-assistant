package com.perfect.team.business.service.base;

import com.perfect.team.business.auth.model.BeanWithUser;
import com.perfect.team.business.auth.model.CustomUserDetails;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class AuthCrudServiceBase<T extends Serializable> extends CrudServiceBase<T>
        implements AuthCrudService<T> {

    protected abstract AuthCrudMapper<T> getMapper();

    @Override
    public T create(T bean) {
        validatePermission(bean);
        return super.create(bean);
    }

    @Override
    public T read(Long id) {
        T bean = super.read(id);
        validatePermission(bean);
        return bean;
    }

    @Override
    public T update(Long id, T bean) {
        validatePermission(bean);
        return super.update(id, bean);
    }

    @Override
    public int delete(Long id) {
        T bean = read(id);
        return super.delete(id);
    }

    @Override
    public List<T> readAllByUserId() {
        return getMapper().selectAllByUserId(getCurrentUser().getId());
    }

    protected User getCurrentUser() {
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }

    protected void validatePermission(T bean) {
        BeanWithUser beanWithUser = (BeanWithUser) bean;
        if (!Objects.equals(beanWithUser.getUser().getId(), getCurrentUser().getId())) {
            throw new ForbiddenException();
        }
    }
}
