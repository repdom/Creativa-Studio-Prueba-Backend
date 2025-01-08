package com.creativa.studios.creativa_studios.adapter.in.rest.book;

import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.CountDeletedBookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.common.ControllerCommons;
import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.DeleteBookUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DeleteBookController {
    private final DeleteBookUseCase deleteBookUseCase;

    public DeleteBookController(DeleteBookUseCase deleteBookUseCase) {
        this.deleteBookUseCase = deleteBookUseCase;
    }

    @DeleteMapping(path = "/api/libros/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CountDeletedBookWebModel> delete(
            @PathVariable("id") long id
    ) {
        Book book;
        try {
            long count = deleteBookUseCase.deleteBook(id);
            return ResponseEntity.ok(
                    CountDeletedBookWebModel.builder().count(count).build()
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
