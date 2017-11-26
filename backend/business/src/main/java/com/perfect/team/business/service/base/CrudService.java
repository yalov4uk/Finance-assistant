package com.perfect.team.business.service.base;

import java.util.List;

public interface CrudService<T> {

    T create(T bean);

    T read(Long id);

    T update(Long id, T bean);

    Long delete(Long id);

    List<T> readAll();
}
