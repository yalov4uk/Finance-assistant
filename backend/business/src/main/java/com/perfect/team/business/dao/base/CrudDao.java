package com.perfect.team.business.dao.base;

import java.util.List;

public interface CrudDao<T> {

    T create(T bean);

    T read(Long id);

    T update(Long id, T bean);

    Long delete(Long id);

    List<T> readAll();
}
