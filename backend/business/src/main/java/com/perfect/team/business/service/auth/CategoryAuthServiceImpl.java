package com.perfect.team.business.service.auth;

import com.perfect.team.business.model.Category;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.CategoryService;
import com.perfect.team.business.service.custom.base.CrudService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CategoryAuthServiceImpl extends AuthCrudServiceBase<Category> implements
    CategoryAuthService {

  @Inject
  private CategoryService categoryService;

  @Override
  protected CrudService<Category> getService() {
    return categoryService;
  }

  @Override
  protected Long getUserId(Category bean) {
    if (bean.getUser() == null) {
      bean.setUser(new User());
    }
    return bean.getUser().getId();
  }

  @Override
  protected void setUserId(Category bean, Long userId) {
    if (bean.getUser() == null) {
      bean.setUser(new User());
    }
    bean.getUser().setId(userId);
  }

  @Override
  public List<Category> readAll() {
    return categoryService.readAllByUserId(getCurrentUser().getId());
  }
}
