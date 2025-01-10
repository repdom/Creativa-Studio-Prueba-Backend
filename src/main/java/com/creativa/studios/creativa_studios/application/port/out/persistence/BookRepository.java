package com.creativa.studios.creativa_studios.application.port.out.persistence;

import com.creativa.studios.creativa_studios.model.book.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(long id);
    Optional<List<Book>> findAll();
    long delete(long id);
    Book save(Book book);
    Book update(Book book);
    Page<Book> getAllPagination(int page, int size, String sortBy, String sortDir, String title);
}
