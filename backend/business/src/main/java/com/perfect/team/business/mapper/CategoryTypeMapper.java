package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.CategoryType;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryTypeMapper extends CrudMapper<CategoryType> {
}
