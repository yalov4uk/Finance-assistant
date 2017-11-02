package com.perfect.team.business.repository;

import com.perfect.team.business.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}