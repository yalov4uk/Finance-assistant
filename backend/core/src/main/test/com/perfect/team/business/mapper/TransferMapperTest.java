package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.entity.Transfer;
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
public class TransferMapperTest {

    @Inject
    private TransferMapper transferMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(createTransfer().getId());
    }

    @Test
    public void select() throws Exception {
        Assert.assertNotNull(transferMapper.select(createTransfer().getId()));
    }

    @Test
    public void update() throws Exception {
        Transfer transfer = createTransfer();
        transfer.setValue(1);
        Assert.assertTrue(transferMapper.update(transfer.getId(), transfer) == 1);
        Assert.assertEquals(1, (int) transfer.getValue());
    }

    @Test
    public void delete() throws Exception {
        Transfer transfer = createTransfer();
        Assert.assertTrue(transferMapper.delete(transfer.getId()) == 1);
        Assert.assertNull(transferMapper.select(transfer.getId()));
    }

    @Test
    public void selectAll() throws Exception {
        Transfer transfer1 = createTransfer();
        Transfer transfer2 = createTransfer();
        List<Transfer> categories = transferMapper.selectAll();
        Assert.assertTrue(categories.contains(transfer1));
        Assert.assertTrue(categories.contains(transfer2));
    }

    @Test
    public void selectWithFull() throws Exception {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString());
        userMapper.insert(user);

        Account account1 = new Account();
        accountMapper.insert(account1);

        Account account2 = new Account();
        accountMapper.insert(account2);

        Transfer transfer = new Transfer();
        transfer.setFromAccount(account1);
        transfer.setToAccount(account2);
        transfer.setUser(user);
        transferMapper.insert(transfer);

        Assert.assertNotNull(transfer.getFromAccount());
        Assert.assertNotNull(transfer.getToAccount());
        Assert.assertNotNull(transfer.getUser());
    }

    private Transfer createTransfer() {
        Transfer transfer = new Transfer();
        transfer.setValue(UUID.randomUUID().hashCode());
        transfer.setDate(new Date());
        transfer.setNote(UUID.randomUUID().toString());
        transferMapper.insert(transfer);
        return transfer;
    }
}
