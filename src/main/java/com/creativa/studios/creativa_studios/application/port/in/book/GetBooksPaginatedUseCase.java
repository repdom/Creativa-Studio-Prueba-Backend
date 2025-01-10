package com.creativa.studios.creativa_studios.application.port.in.book;

import com.creativa.studios.creativa_studios.model.book.Book;
import org.springframework.data.domain.Page;

public interface GetBooksPaginatedUseCase {
    Page<Book> getAllPagination(int page, int size, String sortBy, String sortDir);
}
