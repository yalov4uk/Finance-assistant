package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.Category;
import com.perfect.team.business.entity.Transaction;
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
public class TransactionMapperTest {

    @Inject
    private TransactionMapper transactionMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private CategoryMapper categoryMapper;

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(createTransaction().getId());
    }

    @Test
    public void select() throws Exception {
        Assert.assertNotNull(transactionMapper.select(createTransaction().getId()));
    }

    @Test
    public void update() throws Exception {
        Transaction transaction = createTransaction();
        transaction.setValue(1);
        Assert.assertTrue(transactionMapper.update(transaction) == 1);
        Assert.assertEquals(1, (int) transaction.getValue());
    }

    @Test
    public void delete() throws Exception {
        Transaction transaction = createTransaction();
        Assert.assertTrue(transactionMapper.delete(transaction.getId()) == 1);
        Assert.assertNull(transactionMapper.select(transaction.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        Transaction transaction1 = createTransaction();
        Transaction transaction2 = createTransaction();
        List<Transaction> categories = transactionMapper.selectAll();
        Assert.assertTrue(categories.contains(transaction1));
        Assert.assertTrue(categories.contains(transaction2));
    }

    @Test
    public void selectWithFull() throws Exception {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString());
        userMapper.insert(user);

        Account account = new Account();
        accountMapper.insert(account);

        Category category = new Category();
        categoryMapper.insert(category);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setCategory(category);
        transaction.setUser(user);
        transactionMapper.insert(transaction);

        Assert.assertNotNull(transaction.getAccount());
        Assert.assertNotNull(transaction.getCategory());
        Assert.assertNotNull(transaction.getUser());
    }

    private Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setValue(UUID.randomUUID().hashCode());
        transaction.setDate(new Date());
        transaction.setNote(UUID.randomUUID().toString());
        transactionMapper.insert(transaction);
        return transaction;
    }
}
