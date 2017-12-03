package com.perfect.team.business.mapper;

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
public class UserMapperTest {

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(createUser().getId());
    }

    @Test
    public void select() throws Exception {
        Assert.assertNotNull(userMapper.select(createUser().getId()));
    }

    @Test
    public void update() throws Exception {
        User user = createUser();
        user.setName("test");
        Assert.assertTrue(userMapper.update(user) == 1);
        Assert.assertEquals("test", user.getName());
    }

    @Test
    public void delete() throws Exception {
        User user = createUser();
        Assert.assertTrue(userMapper.delete(user.getId()) == 1);
        Assert.assertNull(userMapper.select(user.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        User user1 = createUser();
        User user2 = createUser();
        List<User> users = userMapper.selectAll();
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));
    }

    private User createUser() {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        userMapper.insert(user);
        return user;
    }
}
