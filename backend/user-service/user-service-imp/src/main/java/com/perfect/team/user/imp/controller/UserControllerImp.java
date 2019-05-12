package com.perfect.team.user.imp.controller;


import com.perfect.team.common.util.CollectionWrapper;
import com.perfect.team.user.api.controller.UserController;
import com.perfect.team.user.api.dto.UserDto;
import com.perfect.team.user.api.dto.UserRequest;
import com.perfect.team.user.api.dto.UserResponse;
import com.perfect.team.user.api.dto.UsersResponse;
import com.perfect.team.user.imp.model.User;
import com.perfect.team.user.imp.service.UserService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class UserControllerImp implements UserController {

  private final UserService service;
  private final Mapper mapper;

  @Override
  public ResponseEntity<URI> create(UserRequest request) {
    User bean = mapper.map(request, User.class);
    Long beanId = service.create(bean);
    URI location = UriComponentsBuilder.fromPath(UserController.USERS)
        .queryParam("id", beanId)
        .build()
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @Override
  public ResponseEntity<UsersResponse> read(UserDto request) {
    CollectionWrapper<User> beans = new CollectionWrapper<>(
        service.read(mapper.map(request, User.class)));
    return ResponseEntity.ok(mapper.map(beans, UsersResponse.class));
  }

  @Override
  public ResponseEntity<UserResponse> update(Long id, UserRequest request) {
    User bean = mapper.map(request, User.class);
    bean.setId(id);
    bean = service.update(bean);
    return ResponseEntity.ok(mapper.map(bean, UserResponse.class));
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}