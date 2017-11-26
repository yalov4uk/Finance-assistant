package com.perfect.team.impl.rest.controller;

import com.perfect.team.api.rest.controller.CategoryController;
import com.perfect.team.api.rest.request.CategoryRequest;
import com.perfect.team.business.entity.User;
import com.perfect.team.business.service.UserService;
import com.perfect.team.impl.rest.service.CategoryRestService;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Denis on 25.11.2017.
 */
@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryControllerImpl implements CategoryController {

    @Inject
    private CategoryRestService categoryRestService;

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAllCategorys() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User currentUser = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            return new HttpEntity<>(categoryRestService.findByUserId(currentUser.getId()));
        } else {
            return new HttpEntity<>("No auth");
        }

    }

    @RequestMapping(path = "/{id}/", method = RequestMethod.GET)
    public HttpEntity getById(@PathVariable("id") Long id) {
        return new HttpEntity<>(categoryRestService.findById(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody CategoryRequest categoryRequest) {
        if (categoryRequest.getCategoryDto().getId() != null) {
            return new HttpEntity<>(categoryRestService.save(categoryRequest));
        } else {
            return new HttpEntity<>("Please add id");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity add(@RequestBody CategoryRequest categoryRequest) {
        if (categoryRequest.getCategoryDto().getId() == null) {
            return new HttpEntity<>(categoryRestService.save(categoryRequest));
        } else {
            return new HttpEntity<>("Can't post with id");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpEntity delete(@RequestBody CategoryRequest categoryRequest) {
        if (categoryRequest.getCategoryDto().getId() != null) {
            categoryRestService.delete(categoryRequest);
            return new HttpEntity<>("ok");
        } else {
            return new HttpEntity<>("Please add id");
        }
    }
}