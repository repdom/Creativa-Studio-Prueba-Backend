package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import com.creativa.studios.creativa_studios.model.book.Book;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

public interface BookJpaSpringRepository extends JpaRepository<BookJpaEntity, Long> {

}
