package com.perfect.team.business.repository.mybatis.mapper;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryMapper extends CrudMapper<Category> {

    Category selectWithUser(Long id);
}
