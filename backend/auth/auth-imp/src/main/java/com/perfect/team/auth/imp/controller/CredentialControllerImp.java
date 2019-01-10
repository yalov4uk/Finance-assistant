package com.perfect.team.auth.imp.controller;

import com.perfect.team.auth.api.CredentialController;
import com.perfect.team.auth.api.dto.CredentialReadRequest;
import com.perfect.team.auth.api.dto.CredentialRequest;
import com.perfect.team.auth.api.dto.CredentialResponse;
import com.perfect.team.auth.api.dto.CredentialsResponse;
import com.perfect.team.auth.imp.model.Credential;
import com.perfect.team.auth.imp.service.CredentialService;
import com.perfect.team.common.util.CollectionWrapper;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class CredentialControllerImp implements CredentialController {

  private final CredentialService service;
  private final Mapper mapper;

  @Override
  public ResponseEntity<URI> create(CredentialRequest request) {
    Credential bean = mapper.map(request, Credential.class);
    Long beanId = service.create(bean);
    URI location = UriComponentsBuilder
        .fromPath(CredentialController.class.getAnnotation(RequestMapping.class).path()[0])
        .path(beanId.toString()).build().toUri();
    return ResponseEntity.created(location).build();
  }

  @Override
  public ResponseEntity<CredentialsResponse> read(CredentialReadRequest request) {
    CollectionWrapper<Credential> beans = new CollectionWrapper<>(service
        .read(request.getId(), request.getUsername(), request.getConfirmed(), request.getUserId()));
    return ResponseEntity.ok(mapper.map(beans, CredentialsResponse.class));
  }

  @Override
  public ResponseEntity<CredentialResponse> update(Long id, CredentialRequest request) {
    Credential bean = mapper.map(request, Credential.class);
    bean.setId(id);
    bean = service.update(bean);
    return ResponseEntity.ok(mapper.map(bean, CredentialResponse.class));
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
