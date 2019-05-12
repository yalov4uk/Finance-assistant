package com.perfect.team.user.imp.repository;


import com.perfect.team.user.imp.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  int insert(User bean);

  User selectById(Long id);

  int update(User bean);

  int delete(Long id);

  List<User> select(@Param("id") Long id, @Param("name") String name);
}
