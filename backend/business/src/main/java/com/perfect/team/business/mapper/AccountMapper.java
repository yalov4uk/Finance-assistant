package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper extends CrudMapper<Account>, AuthCrudMapper<Account> {

    Account selectWithUser(Long id);
}
