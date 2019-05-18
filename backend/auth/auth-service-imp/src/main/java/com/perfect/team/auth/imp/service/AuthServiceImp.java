package com.perfect.team.auth.imp.service;

import com.perfect.team.auth.imp.config.FacebookProperties;
import com.perfect.team.common.security.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImp implements AuthService {

  private final JwtService jwtService;
  private final FacebookProperties facebookProperties;

  @Override
  public String signIn(String username, String password) {
    UserContext userContext = (UserContext) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    return jwtService.sign(userContext.getUserId(), userContext.getAuthorities());
  }

  //todo: fix, signInWithFacebook by filter like signIn
  @Override
  public String signInWithFacebook(String authCode) {
//    FacebookClient facebookClient = new DefaultFacebookClient(accessToken,
//        facebookProperties.appSecret,
//        Version.valueOf(facebookProperties.apiVersion));
//    com.restfb.types.User facebookUser = facebookClient
//        .fetchObject("me", com.restfb.types.User.class,
//            Parameter.with("fields", "email, name"));
//    List<User> users = userMapper.select(null, null, facebookUser.getEmail());
//    User user = users.isEmpty() ? null : users.get(0);
//    if (user != null) {
//      user.setName(facebookUser.getName());
//      user = userService.update(user);
//    } else {
//      user = new User(facebookUser.getName(), facebookUser.getEmail(), true);
//      Long userId = userService.create(user);
//      user.setId(userId);
//    }
//    return jwtService.sign(user.getId(), new ArrayList<>());
    return null;
  }
}
