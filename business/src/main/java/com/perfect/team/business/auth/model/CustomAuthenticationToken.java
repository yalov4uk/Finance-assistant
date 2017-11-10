package com.perfect.team.business.auth.model;

import com.perfect.team.business.auth.AuthService;
import com.perfect.team.business.auth.JwtService;
import com.perfect.team.business.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;

public class CustomAuthenticationToken implements Authentication {

    @Inject
    private JwtService jwtService;

    @Inject
    private UserService userService;

    @Inject
    private AuthService authService;

    private String jwtToken;

    public CustomAuthenticationToken(String jwtToken) {
        this.jwtToken = jwtToken;
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
        return jwtToken;
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getName() {
        return null;
    }
}
