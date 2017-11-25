package com.perfect.team.business.repository.mybatis.dao.base;

import java.util.List;

public interface CrudDao<T> {

    T create(T bean);

    T read(Long id);

    T update(T bean);

    Long delete(Long id);

    List<T> readAll();
}
