package com.perfect.team.business.repository.mybatis.mapper.base;

import java.util.List;

public interface CrudMapper<T> {

    int insert(T bean);

    T select(Long id);

    int update(T bean);

    int delete(Long id);

    List<T> selectAll();
}
