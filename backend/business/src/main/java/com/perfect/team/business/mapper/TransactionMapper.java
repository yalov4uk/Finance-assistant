package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transaction;
import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransactionMapper extends CrudMapper<Transaction> {

  Collection<Transaction> selectByUserId(Long userId);
}
