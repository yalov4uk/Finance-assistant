package com.perfect.team.business.service.base;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T  extends Serializable> {

    T create(T bean);

    T read(Long id);

    T update(Long id, T bean);

    int delete(Long id);

    List<T> readAll();
}
