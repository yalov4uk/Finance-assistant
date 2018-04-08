package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.business.model.Transfer;
import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransferMapper extends CrudMapper<Transfer> {

  Collection<Transfer> selectByUserId(Long userId);
}
