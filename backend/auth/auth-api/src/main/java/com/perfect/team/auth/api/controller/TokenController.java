package com.perfect.team.auth.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.perfect.team.auth.api.dto.TokenResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api
@RequestMapping(path = TokenController.TOKENS, consumes = APPLICATION_JSON_UTF8_VALUE,
    produces = APPLICATION_JSON_UTF8_VALUE)
public interface TokenController {

  String TOKENS = "/tokens";

  @GetMapping
  @ApiResponses(@ApiResponse(code = 200, message = ""))
  ResponseEntity<@NotNull @Valid TokenResponse> decrypt(
      @NotNull @RequestParam("token") String token);
}
