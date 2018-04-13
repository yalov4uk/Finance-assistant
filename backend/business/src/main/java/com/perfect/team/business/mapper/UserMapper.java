package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.User;
import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends CrudMapper<User> {

  Collection<User> selectAll();

  User selectByEmail(String email);
}
