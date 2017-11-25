package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDaoImpl;
import com.perfect.team.business.repository.mybatis.mapper.CategoryMapper;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class CategoryDaoImpl extends CrudDaoImpl<Category> implements CategoryDao {

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    protected CrudMapper<Category> getMapper() {
        return categoryMapper;
    }

    @Override
    public Category readWithUser(Long id) {
        return categoryMapper.selectWithUser(id);
    }
}
