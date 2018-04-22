package com.perfect.team.business.service;

import com.perfect.team.business.event.TransferChangedEvent;
import com.perfect.team.business.mapper.TransferMapper;
import com.perfect.team.business.model.Transfer;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

  @Inject
  private TransferMapper transferMapper;

  @Inject
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Long create(Transfer bean) {
    transferMapper.insert(bean);
    applicationEventPublisher.publishEvent(new TransferChangedEvent(this, null, bean));
    return bean.getId();
  }

  @Override
  public List<Transfer> read(Long id, Date date, Long fromAccountId, Long toAccountId,
      Long userId) {
    return transferMapper.select(id, date, fromAccountId, toAccountId, userId);
  }

  @Override
  public Transfer update(Transfer bean) {
    Transfer oldObject = transferMapper.selectById(bean.getId());
    transferMapper.update(bean);
    Transfer newObject = transferMapper.selectById(bean.getId());
    applicationEventPublisher.publishEvent(new TransferChangedEvent(this, oldObject, newObject));
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Transfer oldObject = transferMapper.selectById(id);
    transferMapper.delete(id);
    applicationEventPublisher.publishEvent(new TransferChangedEvent(this, oldObject, null));
  }
}
