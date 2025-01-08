package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.GetByIdBookUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;

public class GetByIdBookService implements GetByIdBookUseCase {
    private final BookRepository bookRepository;

    public GetByIdBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book getBookById(long id) throws BookNotFoundException {
        if (id <= 0) {
            throw new IllegalArgumentException("'id' must be bigger than 0");
        }
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}
