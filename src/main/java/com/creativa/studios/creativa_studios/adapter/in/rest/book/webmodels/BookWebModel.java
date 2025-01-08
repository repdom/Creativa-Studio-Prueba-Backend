package com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class BookWebModel {
    long id;
    private String title;
    private String author;
    private Date dateOfPublication;
    private double price;
}
