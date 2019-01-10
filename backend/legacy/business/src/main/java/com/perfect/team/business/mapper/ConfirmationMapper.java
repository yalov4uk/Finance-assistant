package com.perfect.team.business.mapper;

import com.perfect.team.business.mapper.base.CrudMapper;
import com.perfect.team.common.model.Confirmation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConfirmationMapper extends CrudMapper<Confirmation> {

  Confirmation selectByCodeAndUserId(@Param("code") String code, @Param("userId") Long userId);
}
