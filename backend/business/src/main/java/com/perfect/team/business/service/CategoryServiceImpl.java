package com.perfect.team.business.service;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import com.perfect.team.business.service.base.AuthCrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class CategoryServiceImpl extends AuthCrudServiceBase<Category> implements CategoryService {

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    protected AuthCrudMapper<Category> getMapper() {
        return categoryMapper;
    }
}
