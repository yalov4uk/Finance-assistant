package com.perfect.team.auth.imp.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.perfect.team.common.security.UserContext;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public interface JwtService {

  String sign(Long userId, Collection<? extends GrantedAuthority> roles);

  UserContext parse(String token);
}
