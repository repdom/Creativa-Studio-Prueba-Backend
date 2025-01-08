package com.creativa.studios.creativa_studios.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.time.Instant;
import java.util.Date;

@Data
@Accessors(fluent = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private BookId bookId;
    private String title;
    private String author;
    private Date dateOfPublication;
    private double price;
}
