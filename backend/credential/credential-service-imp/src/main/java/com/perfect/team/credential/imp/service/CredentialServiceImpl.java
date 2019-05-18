package com.perfect.team.credential.imp.service;

import com.perfect.team.credential.imp.event.EventPublisher;
import com.perfect.team.credential.imp.model.Credential;
import com.perfect.team.credential.imp.repository.CredentialMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {

  private final CredentialMapper credentialMapper;
  private final EventPublisher eventPublisher;

  @Override
  public Long create(Credential bean) {
    credentialMapper.insert(bean);
    eventPublisher.created(bean);
    return bean.getId();
  }

  @Override
  public List<Credential> read(Credential bean) {
    return credentialMapper
        .select(bean.getId(), bean.getUsername(), bean.getConfirmed(), bean.getUserId());
  }

  @Override
  public Credential update(Credential bean) {
    Credential oldObject = credentialMapper.selectById(bean.getId());
    credentialMapper.update(bean);
    Credential newObject = credentialMapper.selectById(bean.getId());
    eventPublisher.updated(oldObject, newObject);
    return newObject;
  }

  @Override
  public void delete(Long id) {
    Credential oldObject = credentialMapper.selectById(id);
    credentialMapper.delete(id);
    eventPublisher.deleted(oldObject);
  }
}
