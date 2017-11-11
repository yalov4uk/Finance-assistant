package com.perfect.team.business.service;

import com.perfect.team.business.auth.JwtService;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.NotFoundException;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.validator.UserValidator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Inject
    private UserValidator userValidator;

    @Inject
    private UserService userService;

    @Inject
    private JwtService jwtService;

    @Override
    public User signUp(User user) {
        if (!userValidator.validate(user)) throw new ValidationException();

        return userService.save(user);
    }

    @Override
    public AuthUser signIn(String username, String password) {
        if (!userValidator.validateUsername(username) || !userValidator.validatePassword(password))
            throw new ValidationException();

        User user = userService.findByUsername(username);
        if (!userValidator.validate(user)) throw new NotFoundException();
        if (!Objects.equals(user.getPassword(), password)) throw new NotFoundException();

        return new AuthUser(user, jwtService.generateToken(user));
    }
}
