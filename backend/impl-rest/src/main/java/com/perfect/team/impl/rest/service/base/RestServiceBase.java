package com.perfect.team.impl.rest.service.base;

import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public abstract class RestServiceBase implements RestService {

    @Inject
    protected ModelMapper modelMapper;
}
