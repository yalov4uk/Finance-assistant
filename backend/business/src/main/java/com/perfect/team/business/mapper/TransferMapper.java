package com.perfect.team.business.mapper;

import com.perfect.team.business.model.Transfer;
import com.perfect.team.business.mapper.base.CrudMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransferMapper extends CrudMapper<Transfer> {

  List<Transfer> selectAllByUserId(Long userId);
}
