package com.perfect.team.impl.rest.service.base;

import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class RestServiceImpl implements RestService {

    @Inject
    protected ModelMapper modelMapper;
}
