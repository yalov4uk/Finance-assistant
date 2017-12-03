package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Category;
import com.perfect.team.business.entity.User;
import com.perfect.team.core.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class CategoryMapperTest {

    @Inject
    private CategoryMapper categoryMapper;

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(createCategory().getId());
    }

    @Test
    public void select() throws Exception {
        Assert.assertNotNull(categoryMapper.select(createCategory().getId()));
    }

    @Test
    public void update() throws Exception {
        Category category = createCategory();
        category.setName("test");
        Assert.assertTrue(categoryMapper.update(category) == 1);
        Assert.assertEquals("test", category.getName());
    }

    @Test
    public void delete() throws Exception {
        Category category = createCategory();
        Assert.assertTrue(categoryMapper.delete(category.getId()) == 1);
        Assert.assertNull(categoryMapper.select(category.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        Category category1 = createCategory();
        Category category2 = createCategory();
        List<Category> categories = categoryMapper.selectAll();
        Assert.assertTrue(categories.contains(category1));
        Assert.assertTrue(categories.contains(category2));
    }

    @Test
    public void selectWithUser() throws Exception {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString());
        userMapper.insert(user);

        Category category = new Category();
        category.setUser(user);
        categoryMapper.insert(category);

        Assert.assertNotNull(category.getUser());
    }

    private Category createCategory() {
        Category category = new Category();
        category.setName(UUID.randomUUID().toString());
        category.setCategoryType(UUID.randomUUID().hashCode());
        category.setIcon(UUID.randomUUID().toString());
        categoryMapper.insert(category);
        return category;
    }
}
