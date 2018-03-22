package com.perfect.team.service.api;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.service.request.SignInRequest;
import com.perfect.team.service.request.SignUpRequest;
import com.perfect.team.service.response.AuthResponse;
import com.perfect.team.service.response.UserResponse;
import com.perfect.team.service.validation.SignIn;
import com.perfect.team.service.validation.SignUp;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService {
    UserResponse signUp(@SignUp SignUpRequest request);

    AuthResponse signIn(@SignIn SignInRequest request, AuthMethod method);
}
