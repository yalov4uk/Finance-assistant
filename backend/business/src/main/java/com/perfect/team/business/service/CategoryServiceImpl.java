package com.perfect.team.business.service;

import com.perfect.team.business.event.CategoryChangedEvent;
import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.model.Category;
import com.perfect.team.business.model.Category.Type;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Inject
  private CategoryMapper categoryMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(Category bean) {
    categoryMapper.insert(bean);
    applicationEventPublisher.publishEvent(new CategoryChangedEvent(this, null, bean));
    return bean.getId();
  }

  @Override
  public List<Category> read(Long id, String name, Type type, Long userId) {
    return categoryMapper.select(id, name, type, userId);
  }

  @Override
  public Category update(Category bean) {
    Category oldObject = categoryMapper.selectById(bean.getId());
    categoryMapper.update(bean);
    Category newObject = categoryMapper.selectById(bean.getId());
    applicationEventPublisher.publishEvent(new CategoryChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Category oldObject = categoryMapper.selectById(id);
    categoryMapper.delete(id);
    applicationEventPublisher.publishEvent(new CategoryChangedEvent(this, oldObject, null));
  }
}
