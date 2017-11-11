package com.perfect.team.impl.rest.mapper;

import com.perfect.team.api.rest.request.SignInRequest;
import com.perfect.team.api.rest.response.SignInResponse;
import com.perfect.team.business.auth.model.AuthUser;
import com.perfect.team.impl.rest.mapper.base.RestMapperImpl;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class SignInMapper extends RestMapperImpl<SignInRequest, AuthUser, SignInResponse> {

    @Inject
    private UserMapper userMapper;

    @Override
    protected Class<AuthUser> getEntityClass() {
        return AuthUser.class;
    }

    @Override
    protected Class<SignInResponse> getResponseClass() {
        return SignInResponse.class;
    }

    @Override
    public SignInResponse mapEntity(AuthUser authUser) {
        SignInResponse signInResponse = super.mapEntity(authUser);
        signInResponse.setUserResponse(userMapper.mapEntity(authUser.getUser()));
        return signInResponse;
    }
}
