package com.perfect.team.business.service;

import com.perfect.team.business.event.CategoryChangedEvent;
import com.perfect.team.business.event.base.ChangedBaseEvent;
import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Category;
import com.perfect.team.business.service.base.CrudServiceBase;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends CrudServiceBase<Category> implements CategoryService {

  @Inject
  private CategoryMapper categoryMapper;


  @Override
  protected CrudMapper<Category> getMapper() {
    return categoryMapper;
  }

  @Override
  protected ChangedBaseEvent<Category> getOnChangeEvent(Object source, Category oldObject,
      Category newObject) {
    return new CategoryChangedEvent(source, oldObject, newObject);
  }

  @Override
  protected Long getPrimaryKey(Category bean) {
    return bean.getId();
  }

  @Override
  public Collection<Category> readByUserId(Long userId) {
    Collection<Category> categories = categoryMapper.selectByUserId(userId);
    validate(categories);
    return categories;
  }
}
