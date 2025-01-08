package com.creativa.studios.creativa_studios.adapter.in.rest.book;

import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.BookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.common.ControllerCommons;
import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.GetByIdBookUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GetByIdBookController {
    private final GetByIdBookUseCase getByIdBookUseCase;

    public GetByIdBookController(GetByIdBookUseCase getByIdBookUseCase) {
        this.getByIdBookUseCase = getByIdBookUseCase;
    }

    @GetMapping(path = "/api/libros/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BookWebModel> getById(
            @PathVariable("id") long id
    ) {
        Book book;
        try {
            book = getByIdBookUseCase.getBookById(id);
            log.info("Book: {}", book);
            return ResponseEntity.ok(BookWebModel.builder()
                    .id(book.bookId().value())
                    .author(book.author())
                    .title(book.title())
                    .price(book.price())
                    .dateOfPublication(book.dateOfPublication())
                    .build()
            );
        } catch (BookNotFoundException e) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ControllerCommons.clientErrorException(HttpStatus.NOT_FOUND, e.getMessage()
                    )
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
