package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.common.model.Credential;
import com.perfect.team.common.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CredentialMapper extends CrudMapper<Credential> {

  List<User> select(@Param("id") Long id, @Param("username") String username,
      @Param("type") Credential.Type type, @Param("confirmed") Boolean confirmed,
      @Param("userId") Long userId);
}
