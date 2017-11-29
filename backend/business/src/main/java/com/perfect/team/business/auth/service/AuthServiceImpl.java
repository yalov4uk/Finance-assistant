package com.perfect.team.business.auth.service;

import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.NotFoundException;
import com.perfect.team.business.exception.ValidationException;
import com.perfect.team.business.service.UserService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Objects;

@Service
@PropertySource("classpath:auth.properties")
public class AuthServiceImpl implements AuthService {

    @Value("${facebook.api.version}")
    private String facebookApiVersion;

    @Value("${facebook.app.id}")
    private String facebookAppId;

    @Value("${facebook.app.secret}")
    private String facebookAppSecret;

    @Inject
    private UserService userService;

    @Inject
    private JwtService jwtService;

    @Override
    public AuthUser signUp(User user, String confirmPassword) {
        if (!Objects.equals(user.getPassword(), confirmPassword)) throw new ValidationException("Passwords mismatch");

        user = userService.create(user);
        return new AuthUser(user, jwtService.generateToken(user));
    }

    @Override
    public AuthUser signIn(String email, String password) {
        User user = userService.readByEmail(email);
        if (user == null || !Objects.equals(user.getPassword(), password)) throw new NotFoundException("User not found");

        return new AuthUser(user, jwtService.generateToken(user));
    }

    @Override
    public AuthUser signInWithFacebook(String accessToken) {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, facebookAppSecret,
                Version.valueOf(facebookApiVersion));
        com.restfb.types.User facebookUser = facebookClient.fetchObject("me", com.restfb.types.User.class,
                Parameter.with("fields", "email, name"));

        if (facebookUser.getEmail() == null) throw new ValidationException("Facebook email is null");

        User user = userService.readByEmail(facebookUser.getEmail());
        if (user != null) {
            user.setName(facebookUser.getName());
            userService.update(user.getId(), user);
        } else {
            user = new User(facebookUser.getName(), facebookUser.getEmail());
            userService.create(user);
        }
        return new AuthUser(user, jwtService.generateToken(user));
    }
}
