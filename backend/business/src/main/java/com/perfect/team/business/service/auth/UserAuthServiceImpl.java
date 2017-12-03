package com.perfect.team.business.service.auth;

import com.perfect.team.business.entity.User;
import com.perfect.team.business.exception.ForbiddenException;
import com.perfect.team.business.service.auth.base.AuthCrudServiceBase;
import com.perfect.team.business.service.custom.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class UserAuthServiceImpl extends AuthCrudServiceBase<User> implements UserAuthService {

    @Inject
    private UserService userService;

    @Override
    public Long create(User bean) {
        throw new ForbiddenException("Create user not allowed");
    }

    @Override
    public User read(Long id) {
        if (Objects.equals(getCurrentUser().getId(), id)) {
            return userService.read(id);
        }
        throw new ForbiddenException("Read other user not allowed");
    }

    @Override
    public User update(Long id, User bean) {
        if (Objects.equals(getCurrentUser().getId(), id)) {
            return userService.update(id, bean);
        }
        throw new ForbiddenException("Update other user not allowed");
    }

    @Override
    public void delete(Long id) {
        if (Objects.equals(getCurrentUser().getId(), id)) {
            userService.delete(id);
        }
        throw new ForbiddenException("Delete other user not allowed");
    }

    /**
     * Only for dev
     *
     * @return all users
     */
    @Override
    public List<User> readAll() {
        return userService.readAll();
    }
}
