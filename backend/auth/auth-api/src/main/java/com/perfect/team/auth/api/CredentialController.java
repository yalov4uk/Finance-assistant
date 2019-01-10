package com.perfect.team.auth.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.dto.CredentialReadRequest;
import com.perfect.team.auth.api.dto.CredentialRequest;
import com.perfect.team.auth.api.dto.CredentialResponse;
import com.perfect.team.auth.api.dto.CredentialsResponse;
import com.perfect.team.auth.api.view.BaseView;
import com.perfect.team.auth.api.view.BaseView.Read;
import com.perfect.team.common.api.validation.constraint.AtLeastOneNotNull;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(authorizations = {@Authorization("Authorization")})
@RequestMapping(path = "/credentials", consumes = APPLICATION_JSON_UTF8_VALUE,
    produces = APPLICATION_JSON_UTF8_VALUE)
public interface CredentialController {

  @PostMapping
  @ApiOperation("")
  @ApiResponses(@ApiResponse(code = 201, message = "", responseHeaders = {
      @ResponseHeader(name = "location", response = URI.class)}))
  ResponseEntity<URI> create(
      @JsonView(BaseView.Create.class) @NotNull @Valid CredentialRequest request);

  @GetMapping
  @JsonView(Read.class)
  @ApiResponses(@ApiResponse(code = 200, message = "", response = CredentialsResponse.class))
  ResponseEntity<CredentialsResponse> read(
      @AtLeastOneNotNull(fieldNames = {"id, userId"}) @Valid CredentialReadRequest request);

  @PutMapping("/{id}")
  @JsonView(Read.class)
  @ApiResponses(@ApiResponse(code = 200, message = "", response = CredentialResponse.class))
  ResponseEntity<CredentialResponse> update(@PathVariable("id") Long id,
      @JsonView(BaseView.Update.class) @NotNull @Valid CredentialRequest request);

  @DeleteMapping("/{id}")
  @ApiResponses(@ApiResponse(code = 204, message = ""))
  ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
