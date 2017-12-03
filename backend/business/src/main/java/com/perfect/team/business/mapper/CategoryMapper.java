package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper extends CrudMapper<Category> {

    Category selectWithUser(Long id);

    List<Category> selectAllByUserId(Long userId);
}
