package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.common.model.Transaction;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransactionMapper extends CrudMapper<Transaction> {

  List<Transaction> select(@Param("id") Long id, @Param("date") Date date,
      @Param("categoryId") Long categoryId, @Param("accountId") Long accountId,
      @Param("userId") Long userId);
}
