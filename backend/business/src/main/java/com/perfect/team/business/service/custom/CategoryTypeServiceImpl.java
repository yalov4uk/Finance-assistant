package com.perfect.team.business.service.custom;

import com.perfect.team.business.mapper.CategoryTypeMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.CategoryType;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CategoryTypeServiceImpl extends CrudServiceBase<CategoryType> implements
    CategoryTypeService {

  @Inject
  private CategoryTypeMapper categoryTypeMapper;

  @Override
  protected CrudMapper<CategoryType> getMapper() {
    return categoryTypeMapper;
  }

  @Override
  protected Long getBeanId(CategoryType bean) {
    return bean.getId();
  }

  @Override
  protected void setBeanId(Long id, CategoryType bean) {
    bean.setId(id);
  }
}
