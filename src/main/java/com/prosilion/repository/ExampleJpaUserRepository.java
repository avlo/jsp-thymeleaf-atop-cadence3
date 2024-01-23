package com.prosilion.repository;

import com.prosilion.model.entity.ExampleJpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleJpaUserRepository extends JpaRepository<ExampleJpaUser, Long> {
}
