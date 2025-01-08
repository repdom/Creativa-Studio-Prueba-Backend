package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.UpdateBookUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;
import com.creativa.studios.creativa_studios.model.book.BookId;

public class UpdateBookService implements UpdateBookUseCase {
    private final BookRepository bookRepository;

    public UpdateBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book updateBook(Book book) throws BookNotFoundException {
        var bookOptional = bookRepository.findById(book.bookId().value()).orElseThrow(BookNotFoundException::new);
        bookOptional.price(book.price());
        bookOptional.title(book.title());
        bookOptional.author(book.author());
        bookOptional.dateOfPublication(book.dateOfPublication());
        return bookRepository.update(bookOptional);
    }
}
