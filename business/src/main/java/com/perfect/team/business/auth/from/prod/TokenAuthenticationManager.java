package com.perfect.team.business.auth.from.prod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TokenAuthenticationManager implements AuthenticationManager {

    @Autowired
    private PassesService passesService;

    @Autowired
    private ApiUserService apiUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication) {
            TokenAuthentication readyTokenAuthentication = processAuthentication((TokenAuthentication) authentication);
            return readyTokenAuthentication;
        }
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken readyBasicAuthentication = processAuthentication((UsernamePasswordAuthenticationToken) authentication);
            return readyBasicAuthentication;
        }
        authentication.setAuthenticated(false);
        return authentication;
    }

    private TokenAuthentication processAuthentication(TokenAuthentication authentication) throws AuthenticationException {
        if (StringUtils.isEmpty(authentication.getToken())) {
            throw new AuthenticationServiceException("Auth token is not presented");
        }
        if (StringUtils.isEmpty(authentication.getPassTypeIdentifier()) || StringUtils.isEmpty(authentication.getSerialNumber())) {
            throw new AuthenticationServiceException("Pass type identifier or pass serial number is not presented");
        }
        Pass pass = passesService.get(authentication.getPassTypeIdentifier(), authentication.getSerialNumber());
        if (pass == null) {
            // throw new AuthenticationServiceException("No pass found for this pass type identifier and serial number");
            // consider pass was already deleted
            return grantTokenAuthentication(authentication);
        }
        if (!authentication.getToken().equals(pass.getAuthToken())) {
            throw new AuthenticationServiceException("Bad token for this pass type identifier and serial number");
        }
        return grantTokenAuthentication(authentication);
    }

    private UsernamePasswordAuthenticationToken processAuthentication(UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        ApiUser user = apiUserService.get(username);
        if (user == null) {
            throw new AuthenticationServiceException("Bad credentials");
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationServiceException("Bad credentials");
        }
        return grantBasicAuthentication(authentication);
    }

    private UsernamePasswordAuthenticationToken grantBasicAuthentication(UsernamePasswordAuthenticationToken authentication) {
        List<GrantedAuthority> authorities =  AuthorityUtils.createAuthorityList("ROLE_API");
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
    }

    private TokenAuthentication grantTokenAuthentication(TokenAuthentication authentication){
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_TOKEN");
        User user = new User("token", "", authorities);
        return new TokenAuthentication(authentication.getToken(), user.getAuthorities(), true, user);
    }
}
