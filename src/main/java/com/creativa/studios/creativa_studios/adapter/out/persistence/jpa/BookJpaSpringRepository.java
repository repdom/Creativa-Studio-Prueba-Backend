package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookJpaSpringRepository extends JpaRepository<BookJpaEntity, Long> {

    Page<BookJpaEntity> findByTitleContaining(String title, Pageable pageable);
}
