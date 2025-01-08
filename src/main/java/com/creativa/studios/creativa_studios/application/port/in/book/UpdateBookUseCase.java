package com.creativa.studios.creativa_studios.application.port.in.book;

import com.creativa.studios.creativa_studios.model.book.Book;

public interface UpdateBookUseCase {
    Book updateBook(Book book) throws BookNotFoundException;
}
