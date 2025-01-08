package com.creativa.studios.creativa_studios.adapter.in.rest.book;


import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.BookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.CreateBookWebModel;
import com.creativa.studios.creativa_studios.application.port.in.book.CreateBookUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CreateBookController {
    private final CreateBookUseCase createBookUseCase;

    public CreateBookController(CreateBookUseCase createBookUseCase) {
        this.createBookUseCase = createBookUseCase;
    }

    @PostMapping(path = "/api/libros", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BookWebModel> create(@RequestBody CreateBookWebModel request) {
        log.info("Creating book: {}", request);
        Book book = createBookUseCase.createBook(
                request.getTitle(),
                request.getAuthor(),
                request.getDateOfPublication(),
                request.getPrice()
        );
        return ResponseEntity.ok(BookWebModel.builder()
                .author(book.author())
                .title(book.title())
                .id(book.bookId().value())
                .price(book.price())
                .dateOfPublication(book.dateOfPublication())
                .build());
    }
}
