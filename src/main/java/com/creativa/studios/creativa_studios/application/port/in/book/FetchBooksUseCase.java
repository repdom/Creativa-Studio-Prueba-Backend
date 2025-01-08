package com.creativa.studios.creativa_studios.application.port.in.book;

import com.creativa.studios.creativa_studios.model.book.Book;

import java.util.List;
import java.util.Optional;

public interface FetchBooksUseCase {
    Optional<List<Book>> getAllBooks();
}
