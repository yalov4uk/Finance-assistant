package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Category;
import com.perfect.team.business.model.Category.Type;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper extends CrudMapper<Category> {

  List<Category> select(@Param("id") Long id, @Param("name") String name,
      @Param("type") Type type, @Param("userId") Long userId);
}
