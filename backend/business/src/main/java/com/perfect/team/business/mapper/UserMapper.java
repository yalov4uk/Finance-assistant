package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends CrudMapper<User> {

  User selectByEmail(String email);
}
