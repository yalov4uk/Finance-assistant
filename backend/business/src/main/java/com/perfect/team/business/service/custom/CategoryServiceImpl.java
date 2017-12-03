package com.perfect.team.business.service.custom;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.service.custom.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CategoryServiceImpl extends CrudServiceBase<Category> implements CategoryService {

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    protected CrudMapper<Category> getMapper() {
        return categoryMapper;
    }

    @Override
    protected Long getBeanId(Category bean) {
        return bean.getId();
    }

    @Override
    protected void setBeanId(Long id, Category bean) {
        bean.setId(id);
    }

    @Override
    public List<Category> readAllByUserId(Long userId) {
        return categoryMapper.selectAllByUserId(userId);
    }
}
