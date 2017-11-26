package com.perfect.team.business.service;

import com.perfect.team.business.entity.Category;

import java.util.List;

/**
 * Created by Denis on 25.11.2017.
 *
 */
public interface CategoryService {
    Category save(Category category);

    List<Category> findByUserId(Long userId);

    Category findById(Long categoryId);

    List<Category> findAll();
    void delete(Long id);
}
