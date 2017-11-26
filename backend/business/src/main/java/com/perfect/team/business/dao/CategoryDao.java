package com.perfect.team.business.repository.mybatis.dao;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.repository.mybatis.dao.base.CrudDao;

public interface CategoryDao extends CrudDao<Category> {

    Category readWithUser(Long id);
}
