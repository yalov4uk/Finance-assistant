package com.perfect.team.business.validator;

import com.perfect.team.business.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User entity) {
        return false;
    }

    @Override
    public boolean validateUsername(String username) {
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        return false;
    }
}
