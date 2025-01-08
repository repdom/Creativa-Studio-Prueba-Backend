package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.FetchBooksUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;

import java.util.List;
import java.util.Optional;

public class FetchBooksService implements FetchBooksUseCase {
    private final BookRepository bookRepository;

    public FetchBooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        return this.bookRepository.findAll();
    }
}
