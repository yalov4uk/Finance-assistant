package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transaction;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransactionMapper extends CrudMapper<Transaction> {

  List<Transaction> selectAllByUserId(Long userId);
}
