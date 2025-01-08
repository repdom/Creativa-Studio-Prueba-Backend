package com.creativa.studios.creativa_studios.application.port.in.book;

import com.creativa.studios.creativa_studios.model.book.Book;

import java.util.Date;

public interface CreateBookUseCase {
    Book createBook(String title, String author, Date dateOfPublication, double price);
}
