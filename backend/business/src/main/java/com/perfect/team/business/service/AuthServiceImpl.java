package com.perfect.team.business.service;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.AuthUser;
import com.perfect.team.business.model.User;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:business.properties")
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
  private UserMapper userMapper;

  @Inject
  private TokenService tokenService;

  @Override
  public User signUp(User user) {
    user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
    Long userId = userService.create(user);
    user.setId(userId);
    return user;
  }

  @Override
  public AuthUser signIn(String email, String password) {
    User user = userMapper.select(null, null, email).get(0);
    return new AuthUser(user, tokenService.encode(user));
  }

  @Override
  public AuthUser signInWith(String token, AuthMethod method) {
    switch (method) {
      case FACEBOOK:
        return signInWithFacebook(token);
      default:
        return null;
    }
  }

  private AuthUser signInWithFacebook(String accessToken) {
    FacebookClient facebookClient = new DefaultFacebookClient(accessToken, facebookAppSecret,
        Version.valueOf(facebookApiVersion));
    com.restfb.types.User facebookUser = facebookClient
        .fetchObject("me", com.restfb.types.User.class,
            Parameter.with("fields", "email, name"));
    List<User> users = userMapper.select(null, null, facebookUser.getEmail());
    User user = users.isEmpty() ? null : users.get(0);
    if (user != null) {
      user.setName(facebookUser.getName());
      user = userService.update(user);
    } else {
      user = new User(facebookUser.getName(), facebookUser.getEmail());
      Long userId = userService.create(user);
      user.setId(userId);
    }
    return new AuthUser(user, tokenService.encode(user));
  }
}
