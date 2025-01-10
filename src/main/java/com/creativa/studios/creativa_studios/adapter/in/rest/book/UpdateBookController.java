package com.creativa.studios.creativa_studios.adapter.in.rest.book;

import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.BookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.UpdateBookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.common.ControllerCommons;
import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.UpdateBookUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import com.creativa.studios.creativa_studios.model.book.BookId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allow all origins for this controller
@RestController
@Slf4j
public class UpdateBookController {
    private final UpdateBookUseCase updateBookUseCase;

    public UpdateBookController(UpdateBookUseCase updateBookUseCase) {
        this.updateBookUseCase = updateBookUseCase;
    }

    @PutMapping(path = "/api/libros/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BookWebModel> update(
            @PathVariable(value = "id", required = true) long id,
            @RequestBody UpdateBookWebModel request
    ) {
        try {
            Book book = Book.builder()
                    .bookId(new BookId(id))
                    .author(request.getAuthor())
                    .title(request.getTitle())
                    .price(request.getPrice())
                    .dateOfPublication(request.getDateOfPublication())
                    .build();
            var updateBook = updateBookUseCase.updateBook(book);
            log.info("Books: {}", updateBook);
            return ResponseEntity.ok(BookWebModel.builder()
                    .id(updateBook.bookId().value())
                    .author(updateBook.author())
                    .title(updateBook.title())
                    .price(updateBook.price())
                    .dateOfPublication(updateBook.dateOfPublication())
                    .build()
            );
        } catch (BookNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ControllerCommons.clientErrorException(HttpStatus.NOT_FOUND, e.getMessage()
                    )
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
