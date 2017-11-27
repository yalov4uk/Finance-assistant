package com.perfect.team.business.mapper.base;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T extends Serializable> {

    int insert(T bean);

    T select(Long id);

    int update(@Param("id") Long id, @Param("bean") T bean);

    int delete(Long id);

    List<T> selectAll();
}
