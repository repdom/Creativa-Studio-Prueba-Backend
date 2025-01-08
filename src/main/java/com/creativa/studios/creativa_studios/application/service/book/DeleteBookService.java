package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.DeleteBookUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;

import java.util.Optional;

public class DeleteBookService implements DeleteBookUseCase {
    private final BookRepository bookRepository;

    public DeleteBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public long deleteBook(long id) throws BookNotFoundException {

        if (id <= 0) {
           throw new IllegalArgumentException("'id' must be bigger than 0");
        }

        Optional<Book> book = this.bookRepository.findById(id);
        if(book.isEmpty()) {
            throw new BookNotFoundException();
        }

        return this.bookRepository.delete(book.get().bookId().value());
    }
}
