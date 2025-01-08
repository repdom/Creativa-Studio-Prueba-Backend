package com.creativa.studios.creativa_studios.adapter.in.rest.book;

import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.BookWebModel;
import com.creativa.studios.creativa_studios.application.port.in.book.FetchBooksUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class FetchBooksController {
    private final FetchBooksUseCase fetchBooksUseCase;

    public FetchBooksController(FetchBooksUseCase fetchBooksUseCase) {
        this.fetchBooksUseCase = fetchBooksUseCase;
    }

    @GetMapping(path = "/api/libros", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<BookWebModel>> getAll() {
        Optional<List<Book>> books = fetchBooksUseCase.getAllBooks();
        if(books.isPresent()) {
            log.info("Books: {}", books.get());
            var booksList = books.get().stream().map(book -> BookWebModel.builder()
                            .author(book.author())
                            .title(book.title())
                            .id(book.bookId().value())
                            .price(book.price())
                            .dateOfPublication(book.dateOfPublication())
                            .build()).toList();
            return ResponseEntity.ok(booksList);
        }
        return ResponseEntity.ok(List.of());
    }
}
