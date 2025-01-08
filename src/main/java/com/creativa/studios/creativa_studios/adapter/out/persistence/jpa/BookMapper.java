package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import com.creativa.studios.creativa_studios.model.book.Book;
import com.creativa.studios.creativa_studios.model.book.BookId;

public class BookMapper {
    private BookMapper() {

    }

    public static BookJpaEntity toJpaEntity(Book book) {
        BookJpaEntity bookJpaEntity = new BookJpaEntity();
        bookJpaEntity.setTitle(book.title());
        bookJpaEntity.setAuthor(book.author());
        bookJpaEntity.setDateOfPublication(book.dateOfPublication());
        bookJpaEntity.setPrice(book.price());
        if(book.bookId() != null) {
            bookJpaEntity.setId(book.bookId().value());
        }
        return bookJpaEntity;
    }

    public static Book toDomain(BookJpaEntity bookJpaEntity) {
        return Book.builder()
                .bookId(new BookId(bookJpaEntity.getId()))
                .author(bookJpaEntity.getAuthor())
                .title(bookJpaEntity.getTitle())
                .dateOfPublication(bookJpaEntity.getDateOfPublication())
                .price(bookJpaEntity.getPrice())
                .build();
    }
}
