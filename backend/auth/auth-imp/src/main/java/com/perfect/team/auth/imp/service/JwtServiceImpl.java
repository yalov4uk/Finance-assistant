package com.perfect.team.auth.imp.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.perfect.team.auth.imp.config.JwtProperties;
import com.perfect.team.common.security.UserContext;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

//todo: expiration time from properties
@Service
public class JwtServiceImpl implements JwtService {

  private static final String USER_ID_CLAIM = "id";
  private static final String ROLES_CLAIM = "rol";

  @Autowired
  private JwtProperties jwtProperties;

  @Override
  public String sign(Long userId, Collection<? extends GrantedAuthority> roles) {
    Algorithm algorithm;
    try {
      algorithm = Algorithm.HMAC256(jwtProperties.secret);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    return JWT.create()
        .withIssuer(jwtProperties.issuer)
        .withClaim(USER_ID_CLAIM, userId)
        .withArrayClaim(ROLES_CLAIM, (String[]) roles.toArray())
        .sign(algorithm);
  }

  @Override
  public UserContext parse(String token) {
    DecodedJWT jwt = verify(token);
    Long userId = jwt.getClaim(USER_ID_CLAIM).asLong();
    Collection<String> roles = jwt.getClaim(ROLES_CLAIM).asList(String.class);
    return new UserContext(userId, roles);
  }

  private DecodedJWT verify(String token) {
    Algorithm algorithm;
    try {
      algorithm = Algorithm.HMAC256(jwtProperties.secret);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer(jwtProperties.issuer)
        .build();
    return verifier.verify(token);
  }
}
