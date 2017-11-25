package com.perfect.team.business.dao;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.repository.mybatis.mapper.AccountMapper;
import com.perfect.team.business.repository.mybatis.mapper.UserMapper;
import com.perfect.team.core.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@TestPropertySource(locations = "classpath:application.properties")
public class AccountMapperTest {

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Account account = new Account();
        accountMapper.insert(account);
        Assert.assertNotNull(account.getId());
    }

    @Test
    public void select() throws Exception {
        Account account = new Account();
        accountMapper.insert(account);
        Assert.assertNotNull(accountMapper.select(account.getId()));
    }

    @Test
    public void update() throws Exception {
        Account account = new Account();
        accountMapper.insert(account);
        account.setName("test");
        Assert.assertTrue(accountMapper.update(account) == 1);
        Assert.assertEquals("test", account.getName());
    }

    @Test
    public void delete() throws Exception {
        Account account = new Account();
        accountMapper.insert(account);
        Assert.assertTrue(accountMapper.delete(account.getId()) == 1);
        Assert.assertNull(accountMapper.select(account.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        Account account1 = new Account();
        accountMapper.insert(account1);
        Account account2 = new Account();
        accountMapper.insert(account2);
        List<Account> accounts = accountMapper.selectAll();
        Assert.assertTrue(accounts.contains(account1));
        Assert.assertTrue(accounts.contains(account2));
    }

    @Test
    public void selectWithUser() throws Exception {
        User user = new User("test", "tewerwejnfejflejrlkfjekrjflkejrlfjlkrjlkjawkjdawdawfegtrg3j23j4234");
        userMapper.insert(user);
        Account account = new Account();
        account.setUser(user);
        accountMapper.insert(account);
        Assert.assertNotNull(account.getUser());
    }
}
