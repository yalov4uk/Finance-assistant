package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transfer;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransferMapper extends CrudMapper<Transfer> {

  List<Transfer> select(@Param("id") Long id, @Param("date") Date date,
      @Param("fromAccountId") Long fromAccountId, @Param("toAccountId") Long toAccountId,
      @Param("userId") Long userId);
}
