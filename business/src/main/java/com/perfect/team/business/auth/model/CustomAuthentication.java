package com.perfect.team.business.auth.model;

import com.perfect.team.business.auth.AuthService;
import com.perfect.team.business.auth.JwtService;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;

public class CustomAuthentication implements Authentication {

    @Inject
    private JwtService jwtService;

    @Inject
    private UserService userService;

    @Inject
    private AuthService authService;

    private String jwtToken;

    public CustomAuthentication(User user) {
        this.jwtToken = jwtService.generateToken(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userService.findByUsername(jwtService.decodeToken(jwtToken));
    }

    @Override
    public boolean isAuthenticated() {
        return authService.checkToken(jwtToken) != null;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
