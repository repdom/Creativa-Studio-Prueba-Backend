package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;
import org.springframework.data.domain.*;
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

    @Override
    public Page<Book> getAllPagination(int page, int size, String sortBy, String sortDir, String title) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.ofSize(size).withPage(page).withSort(sort);
        Page<BookJpaEntity> bookJpaEntitiesPage;
        if (title != null && !title.isEmpty()) {
            bookJpaEntitiesPage = this.bookJpaSpringRepository.findByTitleContaining(title, pageable);
        } else {
            bookJpaEntitiesPage = this.bookJpaSpringRepository.findAll(pageable);
        }
//        Pageable pageable = Pageable.ofSize(size).withPage(page).withSort(sort);

        List<Book> books = bookJpaEntitiesPage.getContent().stream().map(BookMapper::toDomain).toList();

        if (!books.isEmpty()) {
            return new PageImpl<>(books, pageable, bookJpaEntitiesPage.getTotalElements());
        }

        return new PageImpl<>(List.of(), pageable, bookJpaEntitiesPage.getTotalElements());
    }
}
