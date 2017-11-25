package com.perfect.team.business.repository.mybatis.mapper;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.repository.mybatis.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransferMapper extends CrudMapper<Transfer> {

    Transfer selectWithFull(Long id);
}
