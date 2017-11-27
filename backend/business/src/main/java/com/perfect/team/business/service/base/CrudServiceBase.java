package com.perfect.team.business.service.base;

import com.perfect.team.business.dao.base.CrudDao;

import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceBase<T extends Serializable> implements CrudService<T> {

    protected abstract CrudDao<T> getDao();

    @Override
    public T create(T bean) {
        return getDao().create(bean);
    }

    @Override
    public T read(Long id) {
        return getDao().read(id);
    }

    @Override
    public T update(Long id, T bean) {
        return getDao().update(id, bean);
    }

    @Override
    public Long delete(Long id) {
        return getDao().delete(id);
    }

    @Override
    public List<T> readAll() {
        return getDao().readAll();
    }
}
