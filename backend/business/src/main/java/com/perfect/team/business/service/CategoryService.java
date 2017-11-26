package com.perfect.team.business.service;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.service.base.CrudService;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 */
public interface CategoryService extends CrudService<Category> {

    List<Category> readByUserId(Long userId);
}
