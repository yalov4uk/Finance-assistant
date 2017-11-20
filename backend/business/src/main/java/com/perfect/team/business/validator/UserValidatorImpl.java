package com.perfect.team.business.validator;

import com.perfect.team.business.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User entity) {
        return true;
    }

    @Override
    public boolean validateEmail(String email) {
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        return true;
    }
}
