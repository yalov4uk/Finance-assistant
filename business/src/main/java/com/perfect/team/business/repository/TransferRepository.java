package com.perfect.team.business.repository;

import com.perfect.team.business.entity.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@RepositoryRestResource
public interface TransferRepository extends CrudRepository<Transfer, Long> {

}