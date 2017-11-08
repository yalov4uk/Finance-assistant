package com.perfect.team.business.auth;

import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.auth.model.CustomAuthentication;
import com.perfect.team.business.auth.model.CustomUserDetails;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.NotFoundException;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.service.UserService;
import com.perfect.team.business.validator.UserValidator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Inject
    private AuthenticationManager authenticationManager;

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

        authenticate(user);

        String token = jwtService.generateToken(user);

        return new AuthUser(user, token);
    }

    @Override
    public User checkToken(String token) {
        String username = jwtService.decodeToken(token);
        User user = userService.findByUsername(username);

        if (!userValidator.validate(user)) throw new NotFoundException();
        return user;
    }

    private void authenticate(User user) {
        Authentication authentication = new CustomAuthentication(user);
        authenticationManager.authenticate(authentication);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
