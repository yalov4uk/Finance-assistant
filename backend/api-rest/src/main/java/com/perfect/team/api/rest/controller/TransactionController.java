package com.perfect.team.api.rest.controller;

import com.perfect.team.api.rest.controller.base.CrudController;
import com.perfect.team.api.rest.request.entity.TransactionRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/transactions")
@Produces("application/json")
@Consumes("application/json")
public interface TransactionController extends CrudController<TransactionRequest> {
}
