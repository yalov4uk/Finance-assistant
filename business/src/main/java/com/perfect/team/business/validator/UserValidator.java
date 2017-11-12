package com.perfect.team.business.validator;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.validator.base.Validator;

public interface UserValidator extends Validator<User> {

    boolean validateEmail(String email);

    boolean validatePassword(String password);
}
