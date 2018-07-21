package com.perfect.team.business.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.perfect.team.business.config.Auth0Properties;
import com.perfect.team.business.exception.ProcessingException;
import com.perfect.team.common.model.User;
import com.perfect.team.business.security.UserContext;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//todo: expiration time from properties
@Service
public class JwtHelperImpl implements JwtHelper {

  private static final String USER_ID_CLAIM = "id";
  private static final String ROLES_CLAIM = "rol";

  @Inject
  private Auth0Properties auth0Properties;

  @Override
  public String sign(Long userId, Collection<String> roles) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(auth0Properties.secret);
      return JWT.create()
          .withIssuer(auth0Properties.issuer)
          .withClaim(USER_ID_CLAIM, userId)
          .withArrayClaim(ROLES_CLAIM, roles.toArray(new String[0]))
          .sign(algorithm);
    } catch (UnsupportedEncodingException | JWTCreationException exception) {
      throw new ProcessingException(exception.getMessage());
    }
  }

  @Override
  public UserDetails parse(String token)
      throws JWTVerificationException, UnsupportedEncodingException {
    DecodedJWT jwt = verify(token);
    User user = new User();
    user.setId(jwt.getClaim(USER_ID_CLAIM).asLong());
    return new UserContext(user, jwt.getClaim(ROLES_CLAIM).asList(String.class));
  }

  @Override
  public DecodedJWT verify(String token) throws UnsupportedEncodingException {
    Algorithm algorithm = Algorithm.HMAC256(auth0Properties.secret);
    JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer(auth0Properties.issuer)
        .build();
    return verifier.verify(token);
  }
}
