package com.perfect.team.business.service;

import com.perfect.team.business.dao.CategoryDao;
import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.base.CrudServiceBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
@Service
public class CategoryServiceImpl extends CrudServiceBase<Category> implements CategoryService {

    @Inject
    private CategoryDao categoryDao;

    @Override
    protected CrudDao<Category> getDao() {
        return categoryDao;
    }

    @Override
    public List<Category> readByUserId(Long userId) {
        return categoryDao.readByUserId(userId);
    }
}
