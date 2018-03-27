package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Account;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper extends CrudMapper<Account> {

  List<Account> selectAllByUserId(Long userId);
}
