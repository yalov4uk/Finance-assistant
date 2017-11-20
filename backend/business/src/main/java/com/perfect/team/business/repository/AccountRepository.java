package com.perfect.team.business.repository;

import com.perfect.team.business.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}