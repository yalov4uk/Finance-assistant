package com.perfect.team.business.mapper.base;

import java.io.Serializable;
import java.util.List;

public interface AuthCrudMapper<T extends Serializable> extends CrudMapper<T> {

    List<T> selectAllByUserId(Long userId);
}
