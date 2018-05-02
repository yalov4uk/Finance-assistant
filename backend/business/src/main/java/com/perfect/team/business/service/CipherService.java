package com.perfect.team.business.service;

public interface CipherService {

  String encode(Object subject);

  Object decode(String token);
}
