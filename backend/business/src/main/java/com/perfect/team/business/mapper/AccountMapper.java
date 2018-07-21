package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.common.model.Account;
import com.perfect.team.common.model.Account.Currency;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper extends CrudMapper<Account> {

  List<Account> select(@Param("id") Long id, @Param("name") String name,
      @Param("currency") Currency currency, @Param("userId") Long userId);
}
