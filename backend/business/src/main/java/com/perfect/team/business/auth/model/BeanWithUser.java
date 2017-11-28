package com.perfect.team.business.auth.model;

import com.perfect.team.business.entity.User;

public interface BeanWithUser {

    User getUser();

    void setUser(User user);
}
