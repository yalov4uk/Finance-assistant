package com.perfect.team.business.service.helper;

import com.perfect.team.business.model.User;

public interface TokenService {

  String encode(User user);

  String encode(Long userId);

  Long decode(String token);
}
