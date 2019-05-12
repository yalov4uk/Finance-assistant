package com.perfect.team.user.api.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import com.perfect.team.common.api.view.BaseView;
import com.perfect.team.user.api.dto.UserDto;
import com.perfect.team.user.api.dto.UserRequest;
import com.perfect.team.user.api.dto.UserResponse;
import com.perfect.team.user.api.dto.UsersResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(authorizations = @Authorization(AUTHORIZATION))
@RequestMapping(path = "/users", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
public interface UserController {

  @PostMapping
  @ApiOperation("")
  @ApiResponses(
      @ApiResponse(code = 201, message = "", responseHeaders = @ResponseHeader(name = LOCATION)))
  ResponseEntity<URI> create(
      @RequestBody @NotNull @Validated(BaseView.Create.class) UserRequest request);

  @JsonView(BaseView.Read.class)
  @GetMapping("/{id}")
  @ApiResponses(@ApiResponse(code = 200, message = ""))
  ResponseEntity<UsersResponse> read(
      @AtLeastOneNotNull(fieldNames = {"id"}) @Validated(BaseView.Read.class) UserDto request);

  @JsonView(BaseView.Read.class)
  @PatchMapping("/{id}")
  @ApiResponses(@ApiResponse(code = 200, message = ""))
  ResponseEntity<UserResponse> update(
      @PathVariable("id") Long id,
      @NotNull @Validated(BaseView.Update.class) UserRequest request);

  @DeleteMapping("{id}")
  @ApiResponses(@ApiResponse(code = 204, message = ""))
  ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
