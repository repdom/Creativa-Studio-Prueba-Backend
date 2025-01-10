package com.creativa.studios.creativa_studios.adapter.in.rest.book;

import com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels.BookWebModel;
import com.creativa.studios.creativa_studios.adapter.in.rest.common.ControllerCommons;
import com.creativa.studios.creativa_studios.application.port.in.book.BookNotFoundException;
import com.creativa.studios.creativa_studios.application.port.in.book.GetBooksPaginatedUseCase;
import com.creativa.studios.creativa_studios.application.port.in.book.GetByIdBookUseCase;
import com.creativa.studios.creativa_studios.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allow all origins for this controller
@RestController
@Slf4j
public class GetBooksPaginatedController {
    private final GetBooksPaginatedUseCase getBooksPaginatedUseCase;

    public GetBooksPaginatedController(GetBooksPaginatedUseCase getBooksPaginatedUseCase) {
        this.getBooksPaginatedUseCase = getBooksPaginatedUseCase;
    }
    @GetMapping(path = "/api/libros/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<BookWebModel>> getAllPaginated(
            @RequestParam(defaultValue = "0", required = true) int page,
            @RequestParam(defaultValue = "10", required = true) int size,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDir,
            @RequestParam(required = false) String title
    ) {
        Page<Book> bookPage = this.getBooksPaginatedUseCase.getAllPagination(page, size, sortBy, sortDir, title);
        log.info("Book: {}", bookPage);
        return ResponseEntity.ok(new PageImpl<>(bookPage.getContent().stream().map(book -> BookWebModel.builder()
                .author(book.author())
                .title(book.title())
                .id(book.bookId().value())
                .price(book.price())
                .dateOfPublication(book.dateOfPublication())
                .build()).toList(), bookPage.getPageable(), bookPage.getTotalElements()));

    }

}
