package com.creativa.studios.creativa_studios.application.port.in.book;

public interface DeleteBookUseCase {
    long deleteBook(long id) throws BookNotFoundException;
}
