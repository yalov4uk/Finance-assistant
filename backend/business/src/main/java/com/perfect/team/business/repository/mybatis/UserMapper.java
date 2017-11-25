package com.perfect.team.business.repository.mybatis;

import com.perfect.team.business.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer insert(User bean);

    User select(Long id);

    Integer update(User bean);

    Integer delete(Long id);

    List<User> selectAll();
}
