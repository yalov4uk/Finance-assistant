package com.perfect.team.business.validator.base;

import java.io.Serializable;

public interface Validator<T extends Serializable> {

    boolean validate(T entity);
}
