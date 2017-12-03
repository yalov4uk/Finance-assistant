package com.perfect.team.business.mapper.base;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T extends Serializable> {

    int insert(T bean);

    T select(Long id);

    int update(T bean);

    int delete(Long id);

    List<T> selectAll();
}
