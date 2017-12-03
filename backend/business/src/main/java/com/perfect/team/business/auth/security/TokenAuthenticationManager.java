package com.perfect.team.business.auth.security;

import com.perfect.team.business.auth.model.CustomUserDetails;
import com.perfect.team.business.auth.model.TokenAuthentication;
import com.perfect.team.business.auth.service.JwtService;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.custom.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TokenAuthenticationManager implements AuthenticationManager {

    @Inject
    private JwtService jwtService;

    @Inject
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication) {
            authentication = grantTokenAuthentication((TokenAuthentication) authentication);
        }
        return authentication;
    }

    private Authentication grantTokenAuthentication(TokenAuthentication authentication) {
        if (authentication.getToken() != null) {
            Long userId = jwtService.decodeToken(authentication.getToken());
            User user = userService.read(userId);
            if (user != null) {
                UserDetails userDetails = new CustomUserDetails(user);
                authentication = new TokenAuthentication(authentication.getToken(), userDetails);
                authentication.setAuthenticated(true);
                return authentication;
            }
        }
        return null;
    }
}
