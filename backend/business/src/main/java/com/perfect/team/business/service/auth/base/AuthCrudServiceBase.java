package com.perfect.team.business.service.auth.base;

import com.perfect.team.business.auth.model.CustomUserDetails;
import com.perfect.team.business.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

public abstract class AuthCrudServiceBase<T extends Serializable> implements AuthCrudService<T> {

    protected User getCurrentUser() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }
}
