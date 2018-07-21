package com.perfect.team.business.service;

import com.perfect.team.business.config.FacebookProperties;
import com.perfect.team.business.config.Roles;
import com.perfect.team.business.helper.JwtHelper;
import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.model.User;
import com.perfect.team.business.security.UserContext;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Inject
  private FacebookProperties facebookProperties;

  @Inject
  private UserService userService;

  @Inject
  private UserMapper userMapper;

  @Inject
  private JwtHelper jwtHelper;

  @Override
  public String signIn(String email, String password) {
    UserContext userDetails = (UserContext) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
    Long userId = userDetails.getUser().getId();
    Collection<String> roles = userDetails.getAuthorities().stream()
        .map(authority -> (authority).getAuthority().substring(Roles.ROLE_PREFIX.length()))
        .collect(Collectors.toList());
    return jwtHelper.sign(userId, roles);
  }

  //  todo: signInWith by filter like signIn
  @Override
  public String signInWith(String accessToken, AuthMethod method) {
    switch (method) {
      case FACEBOOK:
        return signInWithFacebook(accessToken);
      default:
        return null;
    }
  }

  private String signInWithFacebook(String accessToken) {
    FacebookClient facebookClient = new DefaultFacebookClient(accessToken,
        facebookProperties.appSecret,
        Version.valueOf(facebookProperties.apiVersion));
    com.restfb.types.User facebookUser = facebookClient
        .fetchObject("me", com.restfb.types.User.class,
            Parameter.with("fields", "email, name"));
    List<User> users = userMapper.select(null, null, facebookUser.getEmail());
    User user = users.isEmpty() ? null : users.get(0);
    if (user != null) {
      user.setName(facebookUser.getName());
      user = userService.update(user);
    } else {
      user = new User(facebookUser.getName(), facebookUser.getEmail(), true);
      Long userId = userService.create(user);
      user.setId(userId);
    }
    return jwtHelper.sign(user.getId(), new ArrayList<>());
  }
}
