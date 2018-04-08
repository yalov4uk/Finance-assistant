package com.perfect.team.business.service;

import com.perfect.team.business.model.Category;
import com.perfect.team.business.validation.CategoryCreate;
import com.perfect.team.business.validation.CategoryId;
import com.perfect.team.business.validation.CategoryUpdate;
import com.perfect.team.business.validation.UserId;
import java.util.Collection;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryService {

  Long create(@CategoryCreate Category bean);

  Category read(@CategoryId Long id);

  Category update(@CategoryUpdate Category bean);

  void delete(@CategoryId Long id);

  Collection<Category> readAll();

  Collection<Category> readByUserId(@UserId Long userId);
}
