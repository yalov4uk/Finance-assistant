package com.perfect.team.business.dao.base;

import com.perfect.team.business.mapper.base.CrudMapper;

import java.util.List;

public abstract class CrudDaoImpl<T> implements CrudDao<T> {

    protected abstract CrudMapper<T> getMapper();

    @Override
    public T create(T bean) {
        getMapper().insert(bean);
        return bean;
    }

    @Override
    public T read(Long id) {
        return getMapper().select(id);
    }

    @Override
    public T update(Long id, T bean) {
        getMapper().update(id, bean);
        return getMapper().select(id);
    }

    @Override
    public Long delete(Long id) {
        getMapper().delete(id);
        return id;
    }

    @Override
    public List<T> readAll() {
        return getMapper().selectAll();
    }
}
