package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class BookJpaRepository implements BookRepository {
    private final BookJpaSpringRepository bookJpaSpringRepository;

    public BookJpaRepository(BookJpaSpringRepository bookJpaSpringRepository) {
        this.bookJpaSpringRepository = bookJpaSpringRepository;
    }


    @Override
    public Optional<Book> findById(long id) {
        Optional<BookJpaEntity> bookJpaEntity = bookJpaSpringRepository.findById(id);
        if (bookJpaEntity.isPresent()) {
            Book book = BookMapper.toDomain(bookJpaEntity.get());
            return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Book>> findAll() {
        List<BookJpaEntity> books = bookJpaSpringRepository.findAll();
        if(!books.isEmpty()) {
            return Optional.of(books.stream().map(BookMapper::toDomain).toList());
        }
        return Optional.empty();
    }

    @Override
    public long delete(long id) {
        bookJpaSpringRepository.deleteById(id);
        return 1;
    }

    @Override
    public Book save(Book book) {
        BookJpaEntity bookJpaEntity = BookMapper.toJpaEntity(book);
        var bookPersisted = this.bookJpaSpringRepository.save(bookJpaEntity);
        return BookMapper.toDomain(bookPersisted);
    }

    @Override
    public Book update(Book book) {
        if (book.bookId() != null) {
            BookJpaEntity bookJpaEntity = BookMapper.toJpaEntity(book);
            var bookPersisted = this.bookJpaSpringRepository.save(bookJpaEntity);
            return BookMapper.toDomain(bookPersisted);
        }
        return null;
    }
}