package com.perfect.team.business.service;

import com.perfect.team.business.validation.constraint.CategoryCreate;
import com.perfect.team.business.validation.constraint.CategoryId;
import com.perfect.team.business.validation.constraint.CategoryUpdate;
import com.perfect.team.business.validation.constraint.UserId;
import com.perfect.team.common.model.Category;
import com.perfect.team.common.model.Category.Type;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryService {

  Long create(@CategoryCreate Category bean);

  List<Category> read(@CategoryId Long id, String name, Type type, @UserId Long userId);

  Category update(@CategoryUpdate Category bean);

  void delete(@CategoryId Long id);
}
