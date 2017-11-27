package com.perfect.team.business.dao.base;

import java.io.Serializable;
import java.util.List;

public interface CrudDao<T  extends Serializable> {

    T create(T bean);

    T read(Long id);

    T update(Long id, T bean);

    Long delete(Long id);

    List<T> readAll();
}
