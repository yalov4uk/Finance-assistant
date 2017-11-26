package com.perfect.team.business.repository.mybatis.mapper;

import com.perfect.team.business.entity.Account;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper extends CrudMapper<Account> {

    Account selectWithUser(Long id);
}
