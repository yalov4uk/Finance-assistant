package com.perfect.team.business.service;

import com.perfect.team.business.model.Category;
import com.perfect.team.business.model.Category.Type;
import com.perfect.team.business.validation.CategoryCreate;
import com.perfect.team.business.validation.CategoryId;
import com.perfect.team.business.validation.CategoryIdOrNull;
import com.perfect.team.business.validation.CategoryUpdate;
import com.perfect.team.business.validation.UserIdOrNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryService {

  Long create(@CategoryCreate Category bean);

  List<Category> read(@CategoryIdOrNull Long id, @UserIdOrNull Long userId, Type type);

  Category update(@CategoryUpdate Category bean);

  void delete(@CategoryId Long id);
}
