package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDaoBase;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.mapper.CategoryMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CategoryDaoImpl extends CrudDaoBase<Category> implements CategoryDao {

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

    @Override
    public List<Category> readByUserId(Long userId) {
        return categoryMapper.selectByUserId(userId);
    }
}
