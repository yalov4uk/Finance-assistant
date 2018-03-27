package com.perfect.team.business.mapper;

import com.perfect.team.business.model.Category;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper extends CrudMapper<Category> {

  List<Category> selectAllByUserId(Long userId);
}
