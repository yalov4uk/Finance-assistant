package com.perfect.team.auth.imp.repository;

import com.perfect.team.auth.imp.model.Credential;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CredentialMapper {

  int insert(Credential bean);

  Credential selectById(Long id);

  int update(Credential bean);

  int delete(Long id);

  List<Credential> select(@Param("id") Long id, @Param("username") String username,
      @Param("confirmed") Boolean confirmed, @Param("userId") Long userId);
}
