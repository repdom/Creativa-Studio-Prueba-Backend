package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.CreateBookUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;

import java.util.Date;
import java.util.Objects;

public class CreateBookService implements CreateBookUseCase {
    private final BookRepository bookRepository;

    public CreateBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(String title, String author, Date dateOfPublication, double price) {
        Objects.requireNonNull(author, "'author' must not be null");
        Objects.requireNonNull(title, "'title' must not be null");
        Objects.requireNonNull(dateOfPublication, "'dateOfPublication' must not be null");

        if(price < 0) {
            throw new IllegalArgumentException("'price' must not be less than 0");
        }

        Book book = Book.builder()
                .author(author)
                .title(title)
                .dateOfPublication(dateOfPublication)
                .price(price)
                .build();
        return this.bookRepository.save(book);
    }
}
