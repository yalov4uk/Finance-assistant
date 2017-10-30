package com.team.finance.repository;

import com.team.finance.entity.Transfer;
import com.team.finance.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@RepositoryRestResource
public interface TransferRepository extends CrudRepository<Transfer, Long> {

}