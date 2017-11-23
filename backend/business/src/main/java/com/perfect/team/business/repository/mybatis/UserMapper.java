package com.perfect.team.business.repository.mybatis;

import com.perfect.team.business.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert({"insert into user (name, email, password) values (#{name}, #{email}, #{password})"})
    void create(User bean);

    @Select("select * from user where id = #{id}")
    User get(Long id);

    @Update("update user set name = #{name} where id = #{id}")
    void update(User bean);

    @Delete("delete from user where id = #{id}")
    void delete(Long id);

    @Select("select * from user")
    List<User> getAll();
}
