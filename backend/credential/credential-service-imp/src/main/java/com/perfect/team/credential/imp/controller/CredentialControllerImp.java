package com.perfect.team.credential.imp.controller;


import com.perfect.team.common.security.Role;
import com.perfect.team.common.util.CollectionWrapper;
import com.perfect.team.credential.api.controller.CredentialController;
import com.perfect.team.credential.api.dto.CredentialDto;
import com.perfect.team.credential.api.dto.CredentialRequest;
import com.perfect.team.credential.api.dto.CredentialResponse;
import com.perfect.team.credential.api.dto.CredentialsResponse;
import com.perfect.team.credential.imp.model.Credential;
import com.perfect.team.credential.imp.service.CredentialService;
import java.net.URI;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class CredentialControllerImp implements CredentialController {

  private final CredentialService credentialService;
  private final Mapper mapper;

  @Override
  public ResponseEntity<URI> create(CredentialRequest request) {
    Credential bean = mapper.map(request, Credential.class);
    Long beanId = credentialService.create(bean);
    URI location = UriComponentsBuilder.fromPath(CredentialController.CREDENTIALS)
        .queryParam("id", beanId)
        .build()
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @Override
  public ResponseEntity<CredentialsResponse> read(CredentialDto request) {
    Credential bean = mapper.map(request, Credential.class);
    CollectionWrapper<Credential> beans = new CollectionWrapper<>(credentialService.read(bean));
    return ResponseEntity.ok(mapper.map(beans, CredentialsResponse.class));
  }

  @Override
  @RolesAllowed(Role.CONFIRMED)
  public ResponseEntity<CredentialResponse> update(Long id, CredentialRequest request) {
    Credential bean = mapper.map(request, Credential.class);
    bean.setId(id);
    bean = credentialService.update(bean);
    return ResponseEntity.ok(mapper.map(bean, CredentialResponse.class));
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    credentialService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
