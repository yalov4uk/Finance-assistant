package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Transaction;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransactionMapper extends CrudMapper<Transaction> {

    Transaction selectWithFull(Long id);

    List<Transaction> selectByUserId(Long userId);
}
