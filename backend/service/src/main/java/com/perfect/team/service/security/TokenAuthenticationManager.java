package com.perfect.team.service.security;

import com.perfect.team.business.model.User;
import com.perfect.team.business.service.custom.UserService;
import com.perfect.team.business.service.helper.TokenService;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

    @Inject
    private TokenService tokenService;

    @Inject
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication) {
            return grantTokenAuthentication((TokenAuthentication) authentication);
        }
        throw new AuthenticationServiceException("Wrong Authentication class");
    }

    private Authentication grantTokenAuthentication(TokenAuthentication authentication)
            throws AuthenticationCredentialsNotFoundException, BadCredentialsException {
        if (authentication.getToken() == null) throw new AuthenticationCredentialsNotFoundException("Token is null");
        Long userId = tokenService.decode(authentication.getToken());
        User user = userService.read(userId);
        if (user == null) throw new BadCredentialsException("User not found");
        UserDetails userDetails = new CustomUserDetails(user);
        authentication = new TokenAuthentication(authentication.getToken(), userDetails);
        authentication.setAuthenticated(true);
        return authentication;
    }
}
