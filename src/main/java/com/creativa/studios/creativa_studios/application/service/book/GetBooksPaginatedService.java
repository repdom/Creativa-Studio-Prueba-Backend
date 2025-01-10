package com.creativa.studios.creativa_studios.application.service.book;

import com.creativa.studios.creativa_studios.application.port.in.book.GetBooksPaginatedUseCase;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.model.book.Book;
import org.springframework.data.domain.Page;

public class GetBooksPaginatedService implements GetBooksPaginatedUseCase {
    private final BookRepository bookRepository;

    public GetBooksPaginatedService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getAllPagination(int page, int size, String sortBy, String sortDir) {
        return this.bookRepository.getAllPagination(page, size, sortBy, sortDir);
    }
}
