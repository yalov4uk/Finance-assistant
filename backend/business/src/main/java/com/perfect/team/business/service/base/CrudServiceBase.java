package com.perfect.team.business.service.base;

import com.perfect.team.business.mapper.base.CrudMapper;

import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceBase<T extends Serializable> implements CrudService<T> {

    protected abstract CrudMapper<T> getMapper();

    @Override
    public T create(T bean) {
        int insertedCount = getMapper().insert(bean);
        return bean;
    }

    @Override
    public T read(Long id) {
        return getMapper().select(id);
    }

    @Override
    public T update(Long id, T bean) {
        int updatedCount = getMapper().update(id, bean);
        return read(id);
    }

    @Override
    public int delete(Long id) {
        return getMapper().delete(id);
    }

    @Override
    public List<T> readAll() {
        return getMapper().selectAll();
    }
}
