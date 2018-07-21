package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.common.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends CrudMapper<User> {

  List<User> select(@Param("id") Long id, @Param("name") String name,
      @Param("email") String email);
}
