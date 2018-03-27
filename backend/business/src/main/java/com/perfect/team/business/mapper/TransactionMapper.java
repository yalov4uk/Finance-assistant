package com.perfect.team.business.mapper;

import com.perfect.team.business.model.Transaction;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransactionMapper extends CrudMapper<Transaction> {

  List<Transaction> selectAllByUserId(Long userId);
}
