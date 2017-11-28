package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransactionMapper extends CrudMapper<Transaction>, AuthCrudMapper<Transaction> {

    Transaction selectWithFull(Long id);
}
