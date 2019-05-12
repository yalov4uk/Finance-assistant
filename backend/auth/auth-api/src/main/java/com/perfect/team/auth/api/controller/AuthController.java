package com.perfect.team.auth.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.annotation.JsonView;
import com.perfect.team.auth.api.dto.CredentialRequest;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.api.view.BaseView.SignIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Api
@RequestMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
public interface AuthController {

  @PostMapping("/signIn")
  @ApiResponses(@ApiResponse(code = 200, message = "", response = TokenResponse.class))
  ResponseEntity<TokenResponse> signIn(
      @JsonView(SignIn.class) @NotNull @Valid CredentialRequest request);

  @GetMapping("/signInWithFacebook")
  @ApiResponses(@ApiResponse(code = 200, message = "", response = TokenResponse.class))
  ResponseEntity<TokenResponse> signInWithFacebook(
      @NotNull @RequestParam("authCode") String authCode);
}
