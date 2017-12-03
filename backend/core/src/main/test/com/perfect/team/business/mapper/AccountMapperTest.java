package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.User;
import com.perfect.team.core.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class AccountMapperTest {

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(createAccount().getId());
    }

    @Test
    public void select() throws Exception {
        Assert.assertNotNull(accountMapper.select(createAccount().getId()));
    }

    @Test
    public void update() throws Exception {
        Account account = createAccount();
        account.setName("test");
        Assert.assertTrue(accountMapper.update(account) == 1);
        Assert.assertEquals("test", account.getName());
    }

    @Test
    public void delete() throws Exception {
        Account account = createAccount();
        Assert.assertTrue(accountMapper.delete(account.getId()) == 1);
        Assert.assertNull(accountMapper.select(account.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        Account account1 = createAccount();
        Account account2 = createAccount();
        List<Account> accounts = accountMapper.selectAll();
        Assert.assertTrue(accounts.contains(account1));
        Assert.assertTrue(accounts.contains(account2));
    }

    @Test
    public void selectWithUser() throws Exception {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString());
        userMapper.insert(user);

        Account account = new Account();
        account.setUser(user);
        accountMapper.insert(account);

        Assert.assertNotNull(account.getUser());
    }

    private Account createAccount() {
        Account account = new Account();
        account.setName(UUID.randomUUID().toString());
        account.setInitialDate(new Date());
        account.setIcon(UUID.randomUUID().toString());
        account.setInitialBalance((long) UUID.randomUUID().hashCode());
        accountMapper.insert(account);
        return account;
    }
}
