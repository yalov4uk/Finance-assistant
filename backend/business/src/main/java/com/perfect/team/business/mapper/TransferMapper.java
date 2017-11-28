package com.perfect.team.business.mapper;

import com.perfect.team.business.entity.Transfer;
import com.perfect.team.business.mapper.base.AuthCrudMapper;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TransferMapper extends CrudMapper<Transfer>, AuthCrudMapper<Transfer> {

    Transfer selectWithFull(Long id);
}
