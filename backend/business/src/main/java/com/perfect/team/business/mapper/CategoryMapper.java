package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryMapper extends CrudMapper<Category>, AuthCrudMapper<Category> {

    Category selectWithUser(Long id);
}
