package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.CategoryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryAuthServiceImpl extends AuthCrudServiceBase<Category> implements CategoryAuthService {

    @Inject
    private CategoryService categoryService;

    @Override
    public Long create(Category bean) {
        if (Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return categoryService.create(bean);
        }
        throw new ForbiddenException("Create category to other user not allowed");
    }

    @Override
    public Category read(Long id) {
        Category category = categoryService.read(id);
        if (Objects.equals(getCurrentUser().getId(), category.getUser().getId())) {
            return category;
        }
        throw new ForbiddenException("Read category to other user not allowed");
    }

    @Override
    public Category update(Long id, Category bean) {
        Category category = categoryService.read(id);
        if (Objects.equals(getCurrentUser().getId(), category.getUser().getId())
                && Objects.equals(getCurrentUser().getId(), bean.getUser().getId())) {
            return categoryService.update(id, bean);
        }
        throw new ForbiddenException("Update category of other user not allowed");
    }

    @Override
    public void delete(Long id) {
        Category category = categoryService.read(id);
        if (Objects.equals(getCurrentUser().getId(), category.getUser().getId())) {
            categoryService.delete(id);
        }
        throw new ForbiddenException("Delete category of other user not allowed");
    }

    @Override
    public List<Category> readAll() {
        return categoryService.readAllByUserId(getCurrentUser().getId());
    }
}
