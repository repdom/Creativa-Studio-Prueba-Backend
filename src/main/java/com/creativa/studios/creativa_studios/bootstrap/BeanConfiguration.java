package com.creativa.studios.creativa_studios.bootstrap;

import com.creativa.studios.creativa_studios.adapter.out.persistence.jpa.BookJpaRepository;
import com.creativa.studios.creativa_studios.adapter.out.persistence.jpa.BookJpaSpringRepository;
import com.creativa.studios.creativa_studios.application.port.in.book.*;
import com.creativa.studios.creativa_studios.application.port.out.persistence.BookRepository;
import com.creativa.studios.creativa_studios.application.service.book.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BookRepository bookJpaRepository(BookJpaSpringRepository bookJpaSpringRepository) {
        return new BookJpaRepository(bookJpaSpringRepository);
    }

    @Bean
    public CreateBookUseCase createBookUseCase(BookRepository bookRepository) {
        return new CreateBookService(bookRepository);
    }

    @Bean
    public DeleteBookUseCase deleteBookUseCase(BookRepository bookRepository) {
        return new DeleteBookService(bookRepository);
    }

    @Bean
    public FetchBooksUseCase fetchBooksUseCase(BookRepository bookRepository) {
        return new FetchBooksService(bookRepository);
    }

    @Bean
    public GetByIdBookUseCase getByIdBookUseCase(BookRepository bookRepository) {
        return new GetByIdBookService(bookRepository);
    }

    @Bean
    public UpdateBookUseCase updateBookUseCase(BookRepository bookRepository) {
        return new UpdateBookService(bookRepository);
    }
}
