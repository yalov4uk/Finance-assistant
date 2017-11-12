package com.perfect.team.business.auth.service;

import com.perfect.team.business.entity.User;

public interface JwtService {

    String generateToken(User user);

    Long decodeToken(String token);
}
