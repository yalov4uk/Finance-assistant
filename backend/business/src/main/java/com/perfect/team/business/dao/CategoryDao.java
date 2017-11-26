package com.perfect.team.business.dao;

import com.perfect.team.business.dao.base.CrudDao;
import com.perfect.team.business.entity.Category;

import java.util.List;

public interface CategoryDao extends CrudDao<Category> {

    Category readWithUser(Long id);

    List<Category> readByUserId(Long userId);
}
