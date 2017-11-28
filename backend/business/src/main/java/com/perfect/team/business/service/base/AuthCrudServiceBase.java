package com.perfect.team.business.service.base;

import com.perfect.team.business.mapper.base.AuthCrudMapper;

import java.io.Serializable;
import java.util.List;

public abstract class AuthCrudServiceBase<T extends Serializable> extends CrudServiceBase<T>
        implements AuthCrudService<T> {

    protected abstract AuthCrudMapper<T> getMapper();

    @Override
    public List<T> readAllByUserId(Long userId) {
        return getMapper().selectAllByUserId(userId);
    }
}
