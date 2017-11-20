package com.perfect.team.business.repository;

import com.perfect.team.business.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}