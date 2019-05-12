package com.perfect.team.auth.api.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.dto.CredentialDto;
import com.perfect.team.auth.api.dto.CredentialRequest;
import com.perfect.team.auth.api.dto.CredentialResponse;
import com.perfect.team.auth.api.dto.CredentialsResponse;
import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
import com.perfect.team.common.api.view.BaseView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import javax.validation.Valid;
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
@RequestMapping(path = CredentialController.CREDENTIALS, consumes = APPLICATION_JSON_UTF8_VALUE,
    produces = APPLICATION_JSON_UTF8_VALUE)
public interface CredentialController {

  String CREDENTIALS = "/credentials";

  @PostMapping
  @ApiOperation("")
  @ApiResponses(@ApiResponse(code = 201, message = "",
      responseHeaders = @ResponseHeader(name = LOCATION, response = URI.class)))
  ResponseEntity<URI> create(
      @RequestBody @NotNull @Validated(BaseView.Create.class) CredentialRequest request);

  @GetMapping
  @JsonView(BaseView.Read.class)
  @ApiResponses(@ApiResponse(code = 200, message = ""))
  ResponseEntity<CredentialsResponse> read(
      @JsonView(BaseView.Read.class) @AtLeastOneNotNull(fieldNames = {"id, userId"})
      @Valid CredentialDto request);

  @PatchMapping("/{id}")
  @JsonView(BaseView.Read.class)
  @ApiResponses(@ApiResponse(code = 200, message = ""))
  ResponseEntity<CredentialResponse> update(
      @PathVariable Long id,
      @RequestBody @JsonView(BaseView.Update.class) @NotNull @Valid CredentialRequest request);

  @DeleteMapping("/{id}")
  @ApiResponses(@ApiResponse(code = 204, message = ""))
  ResponseEntity<Void> delete(
      @PathVariable Long id);
}
