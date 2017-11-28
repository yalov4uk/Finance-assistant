package com.perfect.team.business.service.base;

import java.io.Serializable;
import java.util.List;

public interface AuthCrudService<T extends Serializable> extends CrudService<T> {

    List<T> readAllByUserId(Long userId);
}
