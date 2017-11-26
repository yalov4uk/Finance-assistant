package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AccountMapper extends CrudMapper<Account> {

    Account selectWithUser(Long id);

    List<Account> selectByUserId(Long userId);
}
