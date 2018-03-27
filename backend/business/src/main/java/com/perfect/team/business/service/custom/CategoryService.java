package com.perfect.team.business.service.custom;

import com.perfect.team.business.model.Category;
import com.perfect.team.business.service.custom.base.CrudService;
import java.util.List;

public interface CategoryService extends CrudService<Category> {

  List<Category> readAllByUserId(Long userId);
}
